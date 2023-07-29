package com.example.giaitoan.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.giaitoan.model.AnswerModel;
import com.example.giaitoan.model.QuestionModel;
import com.example.giaitoan.model.QuestionWithAnswersModel;

import java.util.ArrayList;
import java.util.List;

public class PlusDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "quiz.db";

    private static final String TABLE_QUESTIONS = "questions";
    private static final String COLUMN_QUESTION_ID = "question_id";
    private static final String COLUMN_QUESTION_TEXT = "question_text";

    private static final String TABLE_ANSWERS = "answers";
    private static final String COLUMN_ANSWER_ID = "answer_id";
    private static final String COLUMN_QUESTION_ID_FOREIGN = "question_id";
    private static final String COLUMN_ANSWER_TEXT = "answer_text";

    public PlusDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_QUESTIONS_TABLE = "CREATE TABLE " + TABLE_QUESTIONS + "("
                + COLUMN_QUESTION_ID + " INTEGER PRIMARY KEY," + COLUMN_QUESTION_TEXT + " TEXT" + ")";

        String CREATE_ANSWERS_TABLE = "CREATE TABLE " + TABLE_ANSWERS + "("
                + COLUMN_ANSWER_ID + " INTEGER PRIMARY KEY," + COLUMN_QUESTION_ID_FOREIGN + " INTEGER,"
                + COLUMN_ANSWER_TEXT + " TEXT," + " FOREIGN KEY ("+COLUMN_QUESTION_ID_FOREIGN+") REFERENCES "+TABLE_QUESTIONS+"("+COLUMN_QUESTION_ID+")"+ ")";

        db.execSQL(CREATE_QUESTIONS_TABLE);
        db.execSQL(CREATE_ANSWERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTIONS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ANSWERS);
        onCreate(db);
    }
    public void addQuestionsWithAnswers(List<QuestionWithAnswersModel> questionsWithAnswers) {
        SQLiteDatabase db = this.getWritableDatabase();

        for (QuestionWithAnswersModel questionWithAnswers : questionsWithAnswers) {
            // Add question
            ContentValues questionValues = new ContentValues();
            questionValues.put(COLUMN_QUESTION_ID, questionWithAnswers.getQuestion().getId());
            questionValues.put(COLUMN_QUESTION_TEXT, questionWithAnswers.getQuestion().getText());
            db.insert(TABLE_QUESTIONS, null, questionValues);

            // Add answers
            for (AnswerModel answer : questionWithAnswers.getAnswers()) {
                ContentValues answerValues = new ContentValues();
                answerValues.put(COLUMN_ANSWER_ID, answer.getId());
                answerValues.put(COLUMN_QUESTION_ID_FOREIGN, answer.getQuestionId());
                answerValues.put(COLUMN_ANSWER_TEXT, answer.getText());
                db.insert(TABLE_ANSWERS, null, answerValues);
            }
        }

        db.close();
    }

    public QuestionWithAnswersModel getRandomQuestionAndAnswers() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor questionCursor = db.rawQuery("SELECT * FROM " + TABLE_QUESTIONS + " ORDER BY RANDOM() LIMIT 1", null);

        QuestionWithAnswersModel questionWithAnswers = new QuestionWithAnswersModel();
        if (questionCursor.moveToFirst()) {
            QuestionModel question = new QuestionModel();
            question.setId(questionCursor.getInt(questionCursor.getColumnIndexOrThrow(COLUMN_QUESTION_ID)));
            question.setText(questionCursor.getString(questionCursor.getColumnIndexOrThrow(COLUMN_QUESTION_TEXT)));
            questionWithAnswers.setQuestion(question);

            Cursor answerCursor = db.rawQuery("SELECT * FROM " + TABLE_ANSWERS + " WHERE " + COLUMN_QUESTION_ID_FOREIGN + " = ? ORDER BY RANDOM() LIMIT 6", new String[]{String.valueOf(question.getId())});

            List<AnswerModel> answers = new ArrayList<>();
            while (answerCursor.moveToNext()) {
                AnswerModel answer = new AnswerModel();
                answer.setId(answerCursor.getInt(answerCursor.getColumnIndexOrThrow(COLUMN_ANSWER_ID)));
                answer.setQuestionId(answerCursor.getInt(answerCursor.getColumnIndexOrThrow(COLUMN_QUESTION_ID_FOREIGN)));
                answer.setText(answerCursor.getString(answerCursor.getColumnIndexOrThrow(COLUMN_ANSWER_TEXT)));
                answers.add(answer);
            }
            questionWithAnswers.setAnswers(answers);

            answerCursor.close();
        }
        questionCursor.close();

        return questionWithAnswers;
    }
}

