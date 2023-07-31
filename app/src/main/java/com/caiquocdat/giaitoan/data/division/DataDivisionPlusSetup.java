package com.caiquocdat.giaitoan.data.division;

import android.content.Context;

import com.caiquocdat.giaitoan.model.AnswerModel;
import com.caiquocdat.giaitoan.model.QuestionModel;
import com.caiquocdat.giaitoan.model.QuestionWithAnswersModel;

import java.util.ArrayList;
import java.util.List;

public class DataDivisionPlusSetup {
    private Context context;

    public DataDivisionPlusSetup(Context context) {
        this.context = context;
    }
    public void setUpDataPlus() {
        // câu hỏi 1
        QuestionModel questionModel_1= new QuestionModel(1,"100 : 50","2");
        AnswerModel answerModel_1= new AnswerModel(1,1,"2");
        AnswerModel answerModel_2= new AnswerModel(2,1,"3");
        AnswerModel answerModel_3= new AnswerModel(3,1,"6");
        AnswerModel answerModel_4= new AnswerModel(4,1,"1");
        AnswerModel answerModel_5= new AnswerModel(5,1,"7");
        AnswerModel answerModel_6= new AnswerModel(6,1,"9");
        List<AnswerModel> answerModelList= new ArrayList<>();
        answerModelList.add(answerModel_1);
        answerModelList.add(answerModel_2);
        answerModelList.add(answerModel_3);
        answerModelList.add(answerModel_4);
        answerModelList.add(answerModel_5);
        answerModelList.add(answerModel_6);
        QuestionWithAnswersModel questionWithAnswersModel= new QuestionWithAnswersModel(questionModel_1,answerModelList);
        // câu hỏi 2
        QuestionModel questionModel_2= new QuestionModel(2,"96 : 12","8");
        AnswerModel answerModel2_1= new AnswerModel(7,2,"5");
        AnswerModel answerModel2_2= new AnswerModel(8,2,"3");
        AnswerModel answerModel2_3= new AnswerModel(9,2,"6");
        AnswerModel answerModel2_4= new AnswerModel(10,2,"10");
        AnswerModel answerModel2_5= new AnswerModel(11,2,"8");
        AnswerModel answerModel2_6= new AnswerModel(12,2,"2");
        List<AnswerModel> answerModelList_2= new ArrayList<>();
        answerModelList_2.add(answerModel2_1);
        answerModelList_2.add(answerModel2_2);
        answerModelList_2.add(answerModel2_3);
        answerModelList_2.add(answerModel2_4);
        answerModelList_2.add(answerModel2_5);
        answerModelList_2.add(answerModel2_6);
        QuestionWithAnswersModel questionWithAnswersModel_2= new QuestionWithAnswersModel(questionModel_2,answerModelList_2);
        // câu hỏi 3
        QuestionModel questionModel_3= new QuestionModel(3,"119 : 17","7");
        AnswerModel answerModel3_1= new AnswerModel(13,3,"6");
        AnswerModel answerModel3_2= new AnswerModel(14,3,"9");
        AnswerModel answerModel3_3= new AnswerModel(15,3,"7");
        AnswerModel answerModel3_4= new AnswerModel(16,3,"4");
        AnswerModel answerModel3_5= new AnswerModel(17,3,"3");
        AnswerModel answerModel3_6= new AnswerModel(18,3,"5");
        List<AnswerModel> answerModelList_3= new ArrayList<>();
        answerModelList_3.add(answerModel3_1);
        answerModelList_3.add(answerModel3_2);
        answerModelList_3.add(answerModel3_3);
        answerModelList_3.add(answerModel3_4);
        answerModelList_3.add(answerModel3_5);
        answerModelList_3.add(answerModel3_6);
        QuestionWithAnswersModel questionWithAnswersModel_3= new QuestionWithAnswersModel(questionModel_3,answerModelList_3);
        // câu hỏi 4
        QuestionModel questionModel_4= new QuestionModel(4,"72 : 12","6");
        AnswerModel answerModel4_1= new AnswerModel(19,4,"6");
        AnswerModel answerModel4_2= new AnswerModel(20,4,"1");
        AnswerModel answerModel4_3= new AnswerModel(21,4,"4");
        AnswerModel answerModel4_4= new AnswerModel(22,4,"2");
        AnswerModel answerModel4_5= new AnswerModel(23,4,"8");
        AnswerModel answerModel4_6= new AnswerModel(24,4,"9");
        List<AnswerModel> answerModelList_4= new ArrayList<>();
        answerModelList_4.add(answerModel4_1);
        answerModelList_4.add(answerModel4_2);
        answerModelList_4.add(answerModel4_3);
        answerModelList_4.add(answerModel4_4);
        answerModelList_4.add(answerModel4_5);
        answerModelList_4.add(answerModel4_6);
        QuestionWithAnswersModel questionWithAnswersModel_4= new QuestionWithAnswersModel(questionModel_4,answerModelList_4);
        // câu hỏi 5
        QuestionModel questionModel_5= new QuestionModel(5,"153 : 9","17");
        AnswerModel answerModel5_1= new AnswerModel(25,5,"10");
        AnswerModel answerModel5_2= new AnswerModel(26,5,"8");
        AnswerModel answerModel5_3= new AnswerModel(27,5,"7");
        AnswerModel answerModel5_4= new AnswerModel(28,5,"12");
        AnswerModel answerModel5_5= new AnswerModel(29,5,"4");
        AnswerModel answerModel5_6= new AnswerModel(30,5,"17");
        List<AnswerModel> answerModelList_5= new ArrayList<>();
        answerModelList_5.add(answerModel5_1);
        answerModelList_5.add(answerModel5_2);
        answerModelList_5.add(answerModel5_3);
        answerModelList_5.add(answerModel5_4);
        answerModelList_5.add(answerModel5_5);
        answerModelList_5.add(answerModel5_6);
        QuestionWithAnswersModel questionWithAnswersModel_5= new QuestionWithAnswersModel(questionModel_5,answerModelList_5);
        // câu hỏi 6
        QuestionModel questionModel_6= new QuestionModel(6,"228 : 19","12");
        AnswerModel answerModel6_1= new AnswerModel(31,6,"5");
        AnswerModel answerModel6_2= new AnswerModel(32,6,"2");
        AnswerModel answerModel6_3= new AnswerModel(33,6,"7");
        AnswerModel answerModel6_4= new AnswerModel(34,6,"14");
        AnswerModel answerModel6_5= new AnswerModel(35,6,"17");
        AnswerModel answerModel6_6= new AnswerModel(36,6,"12");
        List<AnswerModel> answerModelList_6= new ArrayList<>();
        answerModelList_6.add(answerModel6_1);
        answerModelList_6.add(answerModel6_2);
        answerModelList_6.add(answerModel6_3);
        answerModelList_6.add(answerModel6_4);
        answerModelList_6.add(answerModel6_5);
        answerModelList_6.add(answerModel6_6);
        QuestionWithAnswersModel questionWithAnswersModel_6= new QuestionWithAnswersModel(questionModel_6,answerModelList_6);
        // câu hỏi 7
        QuestionModel questionModel_7= new QuestionModel(7,"70 : 5","14");
        AnswerModel answerModel7_1= new AnswerModel(37,7,"15");
        AnswerModel answerModel7_2= new AnswerModel(38,7,"32");
        AnswerModel answerModel7_3= new AnswerModel(39,7,"16");
        AnswerModel answerModel7_4= new AnswerModel(40,7,"14");
        AnswerModel answerModel7_5= new AnswerModel(41,7,"41");
        AnswerModel answerModel7_6= new AnswerModel(42,7,"20");
        List<AnswerModel> answerModelList_7= new ArrayList<>();
        answerModelList_7.add(answerModel7_1);
        answerModelList_7.add(answerModel7_2);
        answerModelList_7.add(answerModel7_3);
        answerModelList_7.add(answerModel7_4);
        answerModelList_7.add(answerModel7_5);
        answerModelList_7.add(answerModel7_6);
        QuestionWithAnswersModel questionWithAnswersModel_7= new QuestionWithAnswersModel(questionModel_7,answerModelList_7);
        // câu hỏi 8
        QuestionModel questionModel_8= new QuestionModel(8,"242 : 11","22");
        AnswerModel answerModel8_1= new AnswerModel(43,8,"22");
        AnswerModel answerModel8_2= new AnswerModel(44,8,"51");
        AnswerModel answerModel8_3= new AnswerModel(45,8,"16");
        AnswerModel answerModel8_4= new AnswerModel(46,8,"9");
        AnswerModel answerModel8_5= new AnswerModel(47,8,"2");
        AnswerModel answerModel8_6= new AnswerModel(48,8,"10");
        List<AnswerModel> answerModelList_8= new ArrayList<>();
        answerModelList_8.add(answerModel8_1);
        answerModelList_8.add(answerModel8_2);
        answerModelList_8.add(answerModel8_3);
        answerModelList_8.add(answerModel8_4);
        answerModelList_8.add(answerModel8_5);
        answerModelList_8.add(answerModel8_6);
        QuestionWithAnswersModel questionWithAnswersModel_8= new QuestionWithAnswersModel(questionModel_8,answerModelList_8);
        // câu hỏi 9
        QuestionModel questionModel_9= new QuestionModel(9,"121 : 11","11");
        AnswerModel answerModel9_1= new AnswerModel(49,9,"11");
        AnswerModel answerModel9_2= new AnswerModel(50,9,"20");
        AnswerModel answerModel9_3= new AnswerModel(51,9,"12");
        AnswerModel answerModel9_4= new AnswerModel(52,9,"31");
        AnswerModel answerModel9_5= new AnswerModel(53,9,"21");
        AnswerModel answerModel9_6= new AnswerModel(54,9,"48");
        List<AnswerModel> answerModelList_9= new ArrayList<>();
        answerModelList_9.add(answerModel9_1);
        answerModelList_9.add(answerModel9_2);
        answerModelList_9.add(answerModel9_3);
        answerModelList_9.add(answerModel9_4);
        answerModelList_9.add(answerModel9_5);
        answerModelList_9.add(answerModel9_6);
        QuestionWithAnswersModel questionWithAnswersModel_9= new QuestionWithAnswersModel(questionModel_9,answerModelList_9);
        // câu hỏi 10
        QuestionModel questionModel_10= new QuestionModel(10,"243 : 9","27");
        AnswerModel answerModel10_1= new AnswerModel(55,10,"23");
        AnswerModel answerModel10_2= new AnswerModel(56,10,"31");
        AnswerModel answerModel10_3= new AnswerModel(57,10,"34");
        AnswerModel answerModel10_4= new AnswerModel(58,10,"27");
        AnswerModel answerModel10_5= new AnswerModel(59,10,"28");
        AnswerModel answerModel10_6= new AnswerModel(60,10,"32");
        List<AnswerModel> answerModelList_10= new ArrayList<>();
        answerModelList_10.add(answerModel10_1);
        answerModelList_10.add(answerModel10_2);
        answerModelList_10.add(answerModel10_3);
        answerModelList_10.add(answerModel10_4);
        answerModelList_10.add(answerModel10_5);
        answerModelList_10.add(answerModel10_6);
        QuestionWithAnswersModel questionWithAnswersModel_10= new QuestionWithAnswersModel(questionModel_10,answerModelList_10);
        //câu hỏi 11
        QuestionModel questionModel_11= new QuestionModel(11,"177 : 3","59");
        AnswerModel answerModel11_1= new AnswerModel(61,11,"63");
        AnswerModel answerModel11_2= new AnswerModel(62,11,"71");
        AnswerModel answerModel11_3= new AnswerModel(63,11,"14");
        AnswerModel answerModel11_4= new AnswerModel(64,11,"67");
        AnswerModel answerModel11_5= new AnswerModel(65,11,"59");
        AnswerModel answerModel11_6= new AnswerModel(66,11,"11");
        List<AnswerModel> answerModelList_11= new ArrayList<>();
        answerModelList_10.add(answerModel11_1);
        answerModelList_10.add(answerModel11_2);
        answerModelList_10.add(answerModel11_3);
        answerModelList_10.add(answerModel11_4);
        answerModelList_10.add(answerModel11_5);
        answerModelList_10.add(answerModel11_6);
        QuestionWithAnswersModel questionWithAnswersModel_11= new QuestionWithAnswersModel(questionModel_11,answerModelList_11);
        // câu hỏi 12
        QuestionModel questionModel_12= new QuestionModel(12,"168 : 3","56");
        AnswerModel answerModel12_1= new AnswerModel(67,12,"63");
        AnswerModel answerModel12_2= new AnswerModel(68,12,"21");
        AnswerModel answerModel12_3= new AnswerModel(69,12,"76");
        AnswerModel answerModel12_4= new AnswerModel(70,12,"19");
        AnswerModel answerModel12_5= new AnswerModel(71,12,"56");
        AnswerModel answerModel12_6= new AnswerModel(72,12,"11");
        List<AnswerModel> answerModelList_12= new ArrayList<>();
        answerModelList_10.add(answerModel12_1);
        answerModelList_10.add(answerModel12_2);
        answerModelList_10.add(answerModel12_3);
        answerModelList_10.add(answerModel12_4);
        answerModelList_10.add(answerModel12_5);
        answerModelList_10.add(answerModel12_6);
        QuestionWithAnswersModel questionWithAnswersModel_12= new QuestionWithAnswersModel(questionModel_12,answerModelList_12);

        List<QuestionWithAnswersModel> withAnswersModelList= new ArrayList<>();
        withAnswersModelList.add(questionWithAnswersModel);
        withAnswersModelList.add(questionWithAnswersModel_2);
        withAnswersModelList.add(questionWithAnswersModel_3);
        withAnswersModelList.add(questionWithAnswersModel_4);
        withAnswersModelList.add(questionWithAnswersModel_5);
        withAnswersModelList.add(questionWithAnswersModel_6);
        withAnswersModelList.add(questionWithAnswersModel_7);
        withAnswersModelList.add(questionWithAnswersModel_8);
        withAnswersModelList.add(questionWithAnswersModel_9);
        withAnswersModelList.add(questionWithAnswersModel_10);
        withAnswersModelList.add(questionWithAnswersModel_11);
        withAnswersModelList.add(questionWithAnswersModel_12);
        DivisionDatabaseHelper divisionDatabaseHelper= new DivisionDatabaseHelper(context);
        divisionDatabaseHelper.addQuestionsWithAnswers(withAnswersModelList);
    }
}
