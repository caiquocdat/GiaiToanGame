package com.example.giaitoan.data.practice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.giaitoan.model.QuestionPra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PracticeDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "questions.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_QUESTIONS = "questions";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_X = "x";
    private static final String COLUMN_PT = "pt";
    private static final String COLUMN_Y = "y";
    private static final String COLUMN_Z = "z";
    private static final String COLUMN_ANSWERS = "answers";
    private static final String COLUMN_CORRECT_ANSWER = "correct_answer";

    // SQL command to create the table
    private static final String CREATE_TABLE_QUESTIONS =
            "CREATE TABLE " + TABLE_QUESTIONS + "(" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_X + " INTEGER, " +
                    COLUMN_PT + " TEXT, " +
                    COLUMN_Y + " INTEGER, " +
                    COLUMN_Z + " INTEGER, " +
                    COLUMN_ANSWERS + " TEXT, " +
                    COLUMN_CORRECT_ANSWER + " TEXT);";

    public PracticeDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_QUESTIONS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Handle database upgrades if needed
        // ...
        // Drop old table if it exists
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTIONS);
        // Recreate the table
        onCreate(db);
    }
    // Add a list of questions
    public void addQuestions(List<QuestionPra> questions) {
        SQLiteDatabase db = this.getWritableDatabase();

        for (QuestionPra question : questions) {
            ContentValues values = new ContentValues();
            values.put(COLUMN_X, question.getX());
            values.put(COLUMN_PT, question.getPt());
            values.put(COLUMN_Y, question.getY());
            values.put(COLUMN_Z, question.getZ());
            values.put(COLUMN_ANSWERS, String.join(",", question.getAnswers()));
            values.put(COLUMN_CORRECT_ANSWER, question.getCorrectAnswer());

            db.insert(TABLE_QUESTIONS, null, values);
        }

        db.close();
    }


    // Phương thức để lấy một câu hỏi ngẫu nhiên
    public QuestionPra getRandomQuestion() {
        SQLiteDatabase db = this.getReadableDatabase();

        String[] columns = {
                COLUMN_X,
                COLUMN_PT,
                COLUMN_Y,
                COLUMN_Z,
                COLUMN_ANSWERS,
                COLUMN_CORRECT_ANSWER
        };

        Cursor cursor = db.query(TABLE_QUESTIONS, columns, null, null, null, null, "RANDOM()", "1");

        QuestionPra question = null;
        if (cursor.moveToFirst()) {
            int x = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_X));
            String pt = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PT));
            int y = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_Y));
            int z = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_Z));
            String answersString = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ANSWERS));
            List<String> answers = Arrays.asList(answersString.split(","));
            String correctAnswer = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CORRECT_ANSWER));

            question = new QuestionPra(x, pt, y, z, new ArrayList<>(answers), correctAnswer);
        }

        cursor.close();

        // Nếu câu hỏi không phải là null (nghĩa là một câu hỏi đã được truy xuất từ cơ sở dữ liệu)
        // thì xáo trộn danh sách các câu trả lời
        if (question != null) {
            Collections.shuffle(question.getAnswers());
        }

        return question;
    }
}
