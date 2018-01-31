package com.mgassociates.bluefin.docs.DatabaseUtils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.mgassociates.bluefin.docs.Models.Category;
import com.mgassociates.bluefin.docs.Models.FAQsInfo;
import com.mgassociates.bluefin.docs.Models.OfficeInfo;
import com.mgassociates.bluefin.docs.Models.RequiredDocsInfo;
import com.mgassociates.bluefin.docs.Models.SubCategory;

import java.util.ArrayList;

/**
 * Created by Rasil10 on 2017-12-13.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    private Context context;

    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "officeDetail";

    // Contacts table name
    private static final String TABLE_OFFICES = "office";
    private static final String TABLE_DOCUMENTS = "documents";
    private static final String TABLE_FAQs = "faqs";


    private static final String TABLE_CATEGORY = "category";
    private static final String TABLE_SUB_CATEGORY = "subCategory";


    // Contacts Table Columns names
    private static final String KEY_ID_OFFICES = "id";
    private static final String KEY_NAME_OFFICES = "name";
    private static final String KEY_PHONE_OFFICES = "phone";
    private static final String KEY_LOCATION_1_OFFICES = "location1";
    private static final String KEY_LOCATION_2_OFFICES = "location2";
    private static final String KEY_LOCATION_3_OFFICES = "location3";
    private static final String KEY_LOCATION_4_OFFICES = "location4";
    private static final String KEY_SHORT_DETAIL_OFFICES = "shortDetail";
    private static final String KEY_TYPE_OFFICES = "type";
    private static final String KEY_BUSY_RATING_OFFICES = "busyRating";


    //Documents table Columns names
    private static final String KEY_ID_DOCUMENTS = "id";
    private static final String KEY_DOC_1_DOCUMENTS = "doc1";
    private static final String KEY_DOC_2_DOCUMENTS = "doc2";
    private static final String KEY_DOC_3_DOCUMENTS = "doc3";
    private static final String KEY_DOC_4_DOCUMENTS = "doc4";
    private static final String KEY_DOC_5_DOCUMENTS = "doc5";
    private static final String KEY_DOC_6_DOCUMENTS = "doc6";
    private static final String KEY_DOC_7_DOCUMENTS = "doc7";
    private static final String KEY_DOC_8_DOCUMENTS = "doc8";
    private static final String KEY_DOC_9_DOCUMENTS = "doc9";
    private static final String KEY_DOC_10_DOCUMENTS = "doc10";
    private static final String KEY_MONEY_DOCUMENTS = "money";

    //FAQs table Columns names
    private static final String KEY_ID_FAQs = "id";
    private static final String KEY_QUESTION_1_FAQs = "question1";
    private static final String KEY_QUESTION_2_FAQs = "question2";
    private static final String KEY_QUESTION_3_FAQs = "question3";
    private static final String KEY_QUESTION_4_FAQs = "question4";
    private static final String KEY_QUESTION_5_FAQs = "question5";
    private static final String KEY_QUESTION_6_FAQs = "question6";
    private static final String KEY_QUESTION_7_FAQs = "question7";
    private static final String KEY_QUESTION_8_FAQs = "question8";
    private static final String KEY_QUESTION_9_FAQs = "question9";
    private static final String KEY_QUESTION_10_FAQs = "question10";
    private static final String KEY_ANSWER_1_FAQs = "answer1";
    private static final String KEY_ANSWER_2_FAQs = "answer2";
    private static final String KEY_ANSWER_3_FAQs = "answer3";
    private static final String KEY_ANSWER_4_FAQs = "answer4";
    private static final String KEY_ANSWER_5_FAQs = "answer5";
    private static final String KEY_ANSWER_6_FAQs = "answer6";
    private static final String KEY_ANSWER_7_FAQs = "answer7";
    private static final String KEY_ANSWER_8_FAQs = "answer8";
    private static final String KEY_ANSWER_9_FAQs = "answer9";
    private static final String KEY_ANSWER_10_FAQs = "answer10";


    //CATEGORY TABLE COLUMNS
    private static final String KEY_ID_CATEGORY = "id";
    private static final String KEY_HEADING_CATEGORY = "heading";
    private static final String KEY_SUBCATEGORY_1_CATEGORY = "category1";
    private static final String KEY_SUBCATEGORY_2_CATEGORY = "category2";
    private static final String KEY_SUBCATEGORY_3_CATEGORY = "category3";
    private static final String KEY_SUBCATEGORY_4_CATEGORY = "category4";
    private static final String KEY_SUBCATEGORY_5_CATEGORY = "category5";
    private static final String KEY_SUBCATEGORY_1_ID_CATEGORY = "category1id";
    private static final String KEY_SUBCATEGORY_2_ID_CATEGORY = "category2id";
    private static final String KEY_SUBCATEGORY_3_ID_CATEGORY = "category3id";
    private static final String KEY_SUBCATEGORY_4_ID_CATEGORY = "category4id";
    private static final String KEY_SUBCATEGORY_5_ID_CATEGORY = "category5id";

    //SUBCATEGORY TABLE COLUMN
    private static final String KEY_ID_SUBCATEGORY = "id";
    private static final String KEY_NAME_SUBCATEGORY = "name";
    private static final String KEY_PHONE_NUMBER_SUBCATEGORY = "phone";
    private static final String KEY_EMAIL_ADDRESS_SUBCATEGORY = "email";
    private static final String KEY_WEBSITE_LINK_SUBCATEGORY = "website";
    private static final String KEY_LOCATION_1_SUBCATEGORY = "location1";
    private static final String KEY_LOCATION_2_SUBCATEGORY = "location2";
    private static final String KEY_LOCATION_3_SUBCATEGORY = "location3";
    private static final String KEY_LOCATION_4_SUBCATEGORY = "location4";
    private static final String KEY_LOCATION_5_SUBCATEGORY = "location5";
    private static final String KEY_LOCATION_6_SUBCATEGORY = "location6";
    private static final String KEY_BUDGET_SUBCATEGORY = "budget";
    private static final String KEY_STEP_1_SUBCATEGORY = "step1";
    private static final String KEY_STEP_2_SUBCATEGORY = "step2";
    private static final String KEY_STEP_3_SUBCATEGORY = "step3";
    private static final String KEY_STEP_4_SUBCATEGORY = "step4";
    private static final String KEY_STEP_5_SUBCATEGORY = "step5";
    private static final String KEY_STEP_6_SUBCATEGORY = "step6";
    private static final String KEY_STEP_7_SUBCATEGORY = "step7";
    private static final String KEY_STEP_8_SUBCATEGORY = "step8";
    private static final String KEY_STEP_9_SUBCATEGORY = "step9";
    private static final String KEY_STEP_10_SUBCATEGORY = "step10";
    private static final String KEY_STEP_11_SUBCATEGORY = "step11";
    private static final String KEY_STEP_12_SUBCATEGORY = "step12";
    private static final String KEY_STEP_13_SUBCATEGORY = "step13";
    private static final String KEY_STEP_14_SUBCATEGORY = "step14";
    private static final String KEY_STEP_15_SUBCATEGORY = "step15";
    private static final String KEY_DOC_1_SUBCATEGORY = "doc1";
    private static final String KEY_DOC_2_SUBCATEGORY = "doc2";
    private static final String KEY_DOC_3_SUBCATEGORY = "doc3";
    private static final String KEY_DOC_4_SUBCATEGORY = "doc4";
    private static final String KEY_DOC_5_SUBCATEGORY = "doc5";
    private static final String KEY_DOC_6_SUBCATEGORY = "doc6";
    private static final String KEY_DOC_7_SUBCATEGORY = "doc7";
    private static final String KEY_DOC_8_SUBCATEGORY = "doc8";
    private static final String KEY_DOC_9_SUBCATEGORY = "doc9";
    private static final String KEY_DOC_10_SUBCATEGORY = "doc10";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_OFFICES_TABLE =
                "CREATE TABLE " + TABLE_OFFICES
                        + "("
                        + KEY_ID_OFFICES + " INTEGER PRIMARY KEY,"
                        + KEY_NAME_OFFICES + " TEXT,"
                        + KEY_PHONE_OFFICES + " TEXT,"
                        + KEY_LOCATION_1_OFFICES + " TEXT,"
                        + KEY_LOCATION_2_OFFICES + " TEXT,"
                        + KEY_LOCATION_3_OFFICES + " TEXT,"
                        + KEY_LOCATION_4_OFFICES + " TEXT,"
                        + KEY_SHORT_DETAIL_OFFICES + " TEXT,"
                        + KEY_TYPE_OFFICES + " TEXT,"
                        + KEY_BUSY_RATING_OFFICES + " INT"
                        + ")";

        String CREATE_DOCUMENT_TABLE = "CREATE TABLE " + TABLE_DOCUMENTS +
                "("
                + KEY_ID_DOCUMENTS + " INTEGER PRIMARY KEY,"
                + KEY_DOC_1_DOCUMENTS + " TEXT,"
                + KEY_DOC_2_DOCUMENTS + " TEXT,"
                + KEY_DOC_3_DOCUMENTS + " TEXT,"
                + KEY_DOC_4_DOCUMENTS + " TEXT,"
                + KEY_DOC_5_DOCUMENTS + " TEXT,"
                + KEY_DOC_6_DOCUMENTS + " TEXT,"
                + KEY_DOC_7_DOCUMENTS + " TEXT,"
                + KEY_DOC_8_DOCUMENTS + " TEXT,"
                + KEY_DOC_9_DOCUMENTS + " TEXT,"
                + KEY_DOC_10_DOCUMENTS + " TEXT,"
                + KEY_MONEY_DOCUMENTS + " INT"
                + ")";

        String CREATE_FAQs_TABLE = "CREATE TABLE " + TABLE_FAQs +
                "("

                + KEY_ID_FAQs + " INTEGER PRIMARY KEY,"

                + KEY_QUESTION_1_FAQs + " TEXT,"
                + KEY_QUESTION_2_FAQs + " TEXT,"
                + KEY_QUESTION_3_FAQs + " TEXT,"
                + KEY_QUESTION_4_FAQs + " TEXT,"
                + KEY_QUESTION_5_FAQs + " TEXT,"
                + KEY_QUESTION_6_FAQs + " TEXT,"
                + KEY_QUESTION_7_FAQs + " TEXT,"
                + KEY_QUESTION_8_FAQs + " TEXT,"
                + KEY_QUESTION_9_FAQs + " TEXT,"
                + KEY_QUESTION_10_FAQs + " TEXT,"

                + KEY_ANSWER_1_FAQs + " TEXT,"
                + KEY_ANSWER_2_FAQs + " TEXT,"
                + KEY_ANSWER_3_FAQs + " TEXT,"
                + KEY_ANSWER_4_FAQs + " TEXT,"
                + KEY_ANSWER_5_FAQs + " TEXT,"
                + KEY_ANSWER_6_FAQs + " TEXT,"
                + KEY_ANSWER_7_FAQs + " TEXT,"
                + KEY_ANSWER_8_FAQs + " TEXT,"
                + KEY_ANSWER_9_FAQs + " TEXT,"
                + KEY_ANSWER_10_FAQs + " TEXT"

                + ")";

        String CREATE_CATEGORY_TABLE = "CREATE TABLE " + TABLE_CATEGORY +
                "("

                + KEY_ID_CATEGORY + " TEXT PRIMARY KEY,"
                + KEY_HEADING_CATEGORY + " TEXT,"

                + KEY_SUBCATEGORY_1_CATEGORY + " TEXT,"
                + KEY_SUBCATEGORY_1_ID_CATEGORY + " TEXT,"

                + KEY_SUBCATEGORY_2_CATEGORY + " TEXT,"
                + KEY_SUBCATEGORY_2_ID_CATEGORY + " TEXT,"

                + KEY_SUBCATEGORY_3_CATEGORY + " TEXT,"
                + KEY_SUBCATEGORY_3_ID_CATEGORY + " TEXT,"

                + KEY_SUBCATEGORY_4_CATEGORY + " TEXT,"
                + KEY_SUBCATEGORY_4_ID_CATEGORY + " TEXT,"

                + KEY_SUBCATEGORY_5_CATEGORY + " TEXT,"
                + KEY_SUBCATEGORY_5_ID_CATEGORY + " TEXT"

                + ")";

        String CREATE_SUB_CATEGORY_TABLE = "CREATE TABLE " + TABLE_SUB_CATEGORY +
                "("

                + KEY_ID_SUBCATEGORY + " TEXT PRIMARY KEY,"
                + KEY_NAME_SUBCATEGORY + " TEXT,"
                + KEY_PHONE_NUMBER_SUBCATEGORY + " TEXT,"
                + KEY_EMAIL_ADDRESS_SUBCATEGORY + " TEXT,"

                + KEY_LOCATION_1_SUBCATEGORY + " TEXT,"
                + KEY_LOCATION_2_SUBCATEGORY + " TEXT,"
                + KEY_LOCATION_3_SUBCATEGORY + " TEXT,"
                + KEY_LOCATION_4_SUBCATEGORY + " TEXT,"
                + KEY_LOCATION_5_SUBCATEGORY + " TEXT,"
                + KEY_LOCATION_6_SUBCATEGORY + " TEXT,"

                + KEY_BUDGET_SUBCATEGORY + " INTEGER,"
                + KEY_STEP_1_SUBCATEGORY + " TEXT,"
                + KEY_STEP_2_SUBCATEGORY + " TEXT,"
                + KEY_STEP_3_SUBCATEGORY + " TEXT,"
                + KEY_STEP_4_SUBCATEGORY + " TEXT,"
                + KEY_STEP_5_SUBCATEGORY + " TEXT,"
                + KEY_STEP_6_SUBCATEGORY + " TEXT,"
                + KEY_STEP_7_SUBCATEGORY + " TEXT,"
                + KEY_STEP_8_SUBCATEGORY + " TEXT,"
                + KEY_STEP_9_SUBCATEGORY + " TEXT,"
                + KEY_STEP_10_SUBCATEGORY + " TEXT,"
                + KEY_STEP_11_SUBCATEGORY + " TEXT,"
                + KEY_STEP_12_SUBCATEGORY + " TEXT,"
                + KEY_STEP_13_SUBCATEGORY + " TEXT,"
                + KEY_STEP_14_SUBCATEGORY + " TEXT,"
                + KEY_STEP_15_SUBCATEGORY + " TEXT,"

                + KEY_DOC_1_SUBCATEGORY + " TEXT,"
                + KEY_DOC_2_SUBCATEGORY + " TEXT,"
                + KEY_DOC_3_SUBCATEGORY + " TEXT,"
                + KEY_DOC_4_SUBCATEGORY + " TEXT,"
                + KEY_DOC_5_SUBCATEGORY + " TEXT,"
                + KEY_DOC_6_SUBCATEGORY + " TEXT,"
                + KEY_DOC_7_SUBCATEGORY + " TEXT,"
                + KEY_DOC_8_SUBCATEGORY + " TEXT,"
                + KEY_DOC_9_SUBCATEGORY + " TEXT,"
                + KEY_DOC_10_SUBCATEGORY + " TEXT,"

                + KEY_WEBSITE_LINK_SUBCATEGORY + " TEXT"

                + ")";

        sqLiteDatabase.execSQL(CREATE_OFFICES_TABLE);
        sqLiteDatabase.execSQL(CREATE_DOCUMENT_TABLE);
        sqLiteDatabase.execSQL(CREATE_FAQs_TABLE);
        sqLiteDatabase.execSQL(CREATE_CATEGORY_TABLE);
        sqLiteDatabase.execSQL(CREATE_SUB_CATEGORY_TABLE);

//         sqLiteDatabase.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_OFFICES);
        onCreate(sqLiteDatabase);
    }


    //add required fields


    public void addOffice(OfficeInfo officeInfo) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID_OFFICES, officeInfo.getId());
        values.put(KEY_NAME_OFFICES, officeInfo.getName());
        values.put(KEY_PHONE_OFFICES, officeInfo.getPhone());

        values.put(KEY_LOCATION_1_OFFICES, officeInfo.getLocations().get(0));
        values.put(KEY_LOCATION_2_OFFICES, officeInfo.getLocations().get(1));
        values.put(KEY_LOCATION_3_OFFICES, officeInfo.getLocations().get(2));
        values.put(KEY_LOCATION_4_OFFICES, officeInfo.getLocations().get(3));

        values.put(KEY_SHORT_DETAIL_OFFICES, officeInfo.getShortDetail());
        values.put(KEY_TYPE_OFFICES, officeInfo.getType());
        values.put(KEY_BUSY_RATING_OFFICES, officeInfo.getBusyRating());

        sqLiteDatabase.insert(TABLE_OFFICES, null, values);


    }

    public void addRequiredDocs(RequiredDocsInfo requiredDocsInfo) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID_DOCUMENTS, requiredDocsInfo.getId());

        values.put(KEY_DOC_1_DOCUMENTS, requiredDocsInfo.getDocs().get(0));
        values.put(KEY_DOC_2_DOCUMENTS, requiredDocsInfo.getDocs().get(1));
        values.put(KEY_DOC_3_DOCUMENTS, requiredDocsInfo.getDocs().get(2));
        values.put(KEY_DOC_4_DOCUMENTS, requiredDocsInfo.getDocs().get(3));
        values.put(KEY_DOC_5_DOCUMENTS, requiredDocsInfo.getDocs().get(4));
        values.put(KEY_DOC_6_DOCUMENTS, requiredDocsInfo.getDocs().get(5));
        values.put(KEY_DOC_7_DOCUMENTS, requiredDocsInfo.getDocs().get(6));
        values.put(KEY_DOC_8_DOCUMENTS, requiredDocsInfo.getDocs().get(7));
        values.put(KEY_DOC_9_DOCUMENTS, requiredDocsInfo.getDocs().get(8));
        values.put(KEY_DOC_10_DOCUMENTS, requiredDocsInfo.getDocs().get(9));

        values.put(KEY_MONEY_DOCUMENTS, requiredDocsInfo.getMoney());

        sqLiteDatabase.insert(TABLE_DOCUMENTS, null, values);

    }

    public void addFAQs(FAQsInfo faQsInfo) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID_FAQs, faQsInfo.getId());

        values.put(KEY_QUESTION_1_FAQs, faQsInfo.getQuestions().get(0));
        values.put(KEY_QUESTION_2_FAQs, faQsInfo.getQuestions().get(1));
        values.put(KEY_QUESTION_3_FAQs, faQsInfo.getQuestions().get(2));
        values.put(KEY_QUESTION_4_FAQs, faQsInfo.getQuestions().get(3));
        values.put(KEY_QUESTION_5_FAQs, faQsInfo.getQuestions().get(4));
        values.put(KEY_QUESTION_6_FAQs, faQsInfo.getQuestions().get(5));
        values.put(KEY_QUESTION_7_FAQs, faQsInfo.getQuestions().get(6));
        values.put(KEY_QUESTION_8_FAQs, faQsInfo.getQuestions().get(7));
        values.put(KEY_QUESTION_9_FAQs, faQsInfo.getQuestions().get(8));
        values.put(KEY_QUESTION_10_FAQs, faQsInfo.getQuestions().get(9));

        values.put(KEY_ANSWER_1_FAQs, faQsInfo.getAnswers().get(0));
        values.put(KEY_ANSWER_2_FAQs, faQsInfo.getAnswers().get(1));
        values.put(KEY_ANSWER_3_FAQs, faQsInfo.getAnswers().get(2));
        values.put(KEY_ANSWER_4_FAQs, faQsInfo.getAnswers().get(3));
        values.put(KEY_ANSWER_5_FAQs, faQsInfo.getAnswers().get(4));
        values.put(KEY_ANSWER_6_FAQs, faQsInfo.getAnswers().get(5));
        values.put(KEY_ANSWER_7_FAQs, faQsInfo.getAnswers().get(6));
        values.put(KEY_ANSWER_8_FAQs, faQsInfo.getAnswers().get(7));
        values.put(KEY_ANSWER_9_FAQs, faQsInfo.getAnswers().get(8));
        values.put(KEY_ANSWER_10_FAQs, faQsInfo.getAnswers().get(9));

        sqLiteDatabase.insert(TABLE_FAQs, null, values);

    }

    public void addCategory(Category category) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_ID_CATEGORY, category.getId());
        values.put(KEY_HEADING_CATEGORY, category.getCategoryName());
        values.put(KEY_SUBCATEGORY_1_ID_CATEGORY, category.getSubCategories().get(0));
        values.put(KEY_SUBCATEGORY_2_ID_CATEGORY, category.getSubCategories().get(1));
        values.put(KEY_SUBCATEGORY_3_ID_CATEGORY, category.getSubCategories().get(2));
        values.put(KEY_SUBCATEGORY_4_ID_CATEGORY, category.getSubCategories().get(3));
        values.put(KEY_SUBCATEGORY_5_ID_CATEGORY, category.getSubCategories().get(4));
        values.put(KEY_SUBCATEGORY_1_CATEGORY, category.getSubCategoriesid().get(0));
        values.put(KEY_SUBCATEGORY_2_CATEGORY, category.getSubCategoriesid().get(1));
        values.put(KEY_SUBCATEGORY_3_CATEGORY, category.getSubCategoriesid().get(2));
        values.put(KEY_SUBCATEGORY_4_CATEGORY, category.getSubCategoriesid().get(3));
        values.put(KEY_SUBCATEGORY_5_CATEGORY, category.getSubCategoriesid().get(4));

        sqLiteDatabase.insert(TABLE_CATEGORY, null, values);


    }

    public void addSubCategory(SubCategory subCategory) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_ID_SUBCATEGORY, subCategory.getId());
        values.put(KEY_NAME_SUBCATEGORY, subCategory.getSubCategoryName());
        values.put(KEY_PHONE_NUMBER_SUBCATEGORY, subCategory.getPhoneNumber());
        values.put(KEY_EMAIL_ADDRESS_SUBCATEGORY, subCategory.getEmailAddress());

        values.put(KEY_LOCATION_1_SUBCATEGORY, subCategory.getLocations().get(0));
        values.put(KEY_LOCATION_2_SUBCATEGORY, subCategory.getLocations().get(1));
        values.put(KEY_LOCATION_3_SUBCATEGORY, subCategory.getLocations().get(2));
        values.put(KEY_LOCATION_4_SUBCATEGORY, subCategory.getLocations().get(3));
        values.put(KEY_LOCATION_5_SUBCATEGORY, subCategory.getLocations().get(4));
        values.put(KEY_LOCATION_6_SUBCATEGORY, subCategory.getLocations().get(5));

        values.put(KEY_BUDGET_SUBCATEGORY, subCategory.getBudget());

        values.put(KEY_STEP_1_SUBCATEGORY, subCategory.getSteps().get(0));
        values.put(KEY_STEP_2_SUBCATEGORY, subCategory.getSteps().get(1));
        values.put(KEY_STEP_3_SUBCATEGORY, subCategory.getSteps().get(2));
        values.put(KEY_STEP_4_SUBCATEGORY, subCategory.getSteps().get(3));
        values.put(KEY_STEP_5_SUBCATEGORY, subCategory.getSteps().get(4));
        values.put(KEY_STEP_6_SUBCATEGORY, subCategory.getSteps().get(5));
        values.put(KEY_STEP_7_SUBCATEGORY, subCategory.getSteps().get(6));
        values.put(KEY_STEP_8_SUBCATEGORY, subCategory.getSteps().get(7));
        values.put(KEY_STEP_9_SUBCATEGORY, subCategory.getSteps().get(8));
        values.put(KEY_STEP_10_SUBCATEGORY, subCategory.getSteps().get(9));
        values.put(KEY_STEP_11_SUBCATEGORY, subCategory.getSteps().get(10));
        values.put(KEY_STEP_12_SUBCATEGORY, subCategory.getSteps().get(11));
        values.put(KEY_STEP_13_SUBCATEGORY, subCategory.getSteps().get(12));
        values.put(KEY_STEP_14_SUBCATEGORY, subCategory.getSteps().get(13));
        values.put(KEY_STEP_15_SUBCATEGORY, subCategory.getSteps().get(14));

        values.put(KEY_DOC_1_SUBCATEGORY, subCategory.getRequiredDocs().get(0));
        values.put(KEY_DOC_2_SUBCATEGORY, subCategory.getRequiredDocs().get(1));
        values.put(KEY_DOC_3_SUBCATEGORY, subCategory.getRequiredDocs().get(2));
        values.put(KEY_DOC_4_SUBCATEGORY, subCategory.getRequiredDocs().get(3));
        values.put(KEY_DOC_5_SUBCATEGORY, subCategory.getRequiredDocs().get(4));
        values.put(KEY_DOC_6_SUBCATEGORY, subCategory.getRequiredDocs().get(5));
        values.put(KEY_DOC_7_SUBCATEGORY, subCategory.getRequiredDocs().get(6));
        values.put(KEY_DOC_8_SUBCATEGORY, subCategory.getRequiredDocs().get(7));
        values.put(KEY_DOC_9_SUBCATEGORY, subCategory.getRequiredDocs().get(8));
        values.put(KEY_DOC_10_SUBCATEGORY, subCategory.getRequiredDocs().get(9));

        values.put(KEY_WEBSITE_LINK_SUBCATEGORY, subCategory.getWebsite());

        sqLiteDatabase.insert(TABLE_SUB_CATEGORY, null, values);


    }


    //get single required info


    public SubCategory getSubCategory(String id) {

        SubCategory subCategory = new SubCategory();
        String selectQuery = "SELECT  * FROM " + TABLE_SUB_CATEGORY + " WHERE ID = " + "\"" + id + "\"";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        String[] data = null;

        if (cursor.moveToFirst()) {
            do {

                ArrayList<String> locations = new ArrayList<>();
                ArrayList<String> steps = new ArrayList<>();
                ArrayList<String> docs = new ArrayList<>();

                subCategory.setId(cursor.getString(0));
                subCategory.setSubCategoryName(cursor.getString(1));
                subCategory.setPhoneNumber(cursor.getString(2));
                subCategory.setEmailAddress(cursor.getString(3));

                locations.add(cursor.getString(4));
                locations.add(cursor.getString(5));
                locations.add(cursor.getString(6));
                locations.add(cursor.getString(7));
                locations.add(cursor.getString(8));
                locations.add(cursor.getString(9));
                subCategory.setLocations(locations);

                subCategory.setBudget(Integer.parseInt(cursor.getString(10)));

                steps.add(cursor.getString(11));
                steps.add(cursor.getString(12));
                steps.add(cursor.getString(13));
                steps.add(cursor.getString(14));
                steps.add(cursor.getString(15));
                steps.add(cursor.getString(16));
                steps.add(cursor.getString(17));
                steps.add(cursor.getString(18));
                steps.add(cursor.getString(19));
                steps.add(cursor.getString(20));
                steps.add(cursor.getString(21));
                steps.add(cursor.getString(22));
                steps.add(cursor.getString(23));
                steps.add(cursor.getString(24));
                steps.add(cursor.getString(25));
                subCategory.setSteps(steps);

                docs.add(cursor.getString(26));
                docs.add(cursor.getString(27));
                docs.add(cursor.getString(28));
                docs.add(cursor.getString(29));
                docs.add(cursor.getString(30));
                docs.add(cursor.getString(31));
                docs.add(cursor.getString(32));
                docs.add(cursor.getString(33));
                docs.add(cursor.getString(34));
                docs.add(cursor.getString(35));
                subCategory.setRequiredDocs(docs);

                subCategory.setWebsite(cursor.getString(36));


            } while (cursor.moveToNext());
        }


        return subCategory;

    }

    public OfficeInfo getOffice(int id) {

        OfficeInfo officeInfo = new OfficeInfo();
        String selectQuery = "SELECT  * FROM " + TABLE_OFFICES + " WHERE ID = " + String.valueOf(id);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        String[] data = null;

        if (cursor.moveToFirst()) {
            do {
                ArrayList<String> locations = new ArrayList<>();

                locations.add(cursor.getString(3));
                locations.add(cursor.getString(4));
                locations.add(cursor.getString(5));
                locations.add(cursor.getString(6));

                officeInfo.setId(Integer.parseInt(cursor.getString(0)));
                officeInfo.setName(cursor.getString(1));
                officeInfo.setPhone(cursor.getString(2));
                officeInfo.setLocations(locations);
                officeInfo.setShortDetail(cursor.getString(7));
                officeInfo.setType(cursor.getString(8));
                officeInfo.setBusyRating(Integer.parseInt(cursor.getString(9)));


            } while (cursor.moveToNext());
        }


        return officeInfo;

    }

    public RequiredDocsInfo getRequiredDoc(int id) {

        RequiredDocsInfo docsInfo = new RequiredDocsInfo();
        String selectQuery = "SELECT  * FROM " + TABLE_DOCUMENTS + " WHERE ID = " + String.valueOf(id);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        String[] data = null;

        if (cursor.moveToFirst()) {
            do {
                ArrayList<String> docs = new ArrayList<>();

                docs.add(cursor.getString(1));
                docs.add(cursor.getString(2));
                docs.add(cursor.getString(3));
                docs.add(cursor.getString(4));
                docs.add(cursor.getString(5));
                docs.add(cursor.getString(6));
                docs.add(cursor.getString(7));
                docs.add(cursor.getString(8));
                docs.add(cursor.getString(9));
                docs.add(cursor.getString(10));

                docsInfo.setId(Integer.parseInt(cursor.getString(0)));
                docsInfo.setDocs(docs);
                docsInfo.setMoney(Integer.parseInt(cursor.getString(11)));


            } while (cursor.moveToNext());
        }

        return docsInfo;

    }

    public FAQsInfo getFAQ(int id) {
        FAQsInfo faq = new FAQsInfo();

        final String TABLE_NAME = "name of table";

        String selectQuery = "SELECT  * FROM " + TABLE_FAQs + " WHERE ID = " + String.valueOf(id);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        String[] data = null;

        if (cursor.moveToFirst()) {
            do {
                ArrayList<String> questions = new ArrayList<>();
                ArrayList<String> answers = new ArrayList<>();

                faq.setId(Integer.parseInt(cursor.getString(0)));

                questions.add(cursor.getString(1));
                questions.add(cursor.getString(2));
                questions.add(cursor.getString(3));
                questions.add(cursor.getString(4));
                questions.add(cursor.getString(5));
                questions.add(cursor.getString(6));
                questions.add(cursor.getString(7));
                questions.add(cursor.getString(8));
                questions.add(cursor.getString(9));
                questions.add(cursor.getString(10));

                answers.add(cursor.getString(11));
                answers.add(cursor.getString(12));
                answers.add(cursor.getString(13));
                answers.add(cursor.getString(14));
                answers.add(cursor.getString(15));
                answers.add(cursor.getString(16));
                answers.add(cursor.getString(17));
                answers.add(cursor.getString(18));
                answers.add(cursor.getString(19));
                answers.add(cursor.getString(20));

                faq.setQuestions(questions);
                faq.setAnswers(answers);
            } while (cursor.moveToNext());
        }
        return faq;
    }

    public Category getCategory(String id) {

        Category category = new Category();
        String selectQuery = "SELECT  * FROM " + TABLE_CATEGORY + " WHERE ID = " + "\"" + id + "\"";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        String[] data = null;

        if (cursor.moveToFirst()) {
            do {
                ArrayList<String> subCategories = new ArrayList<>();
                ArrayList<String> subCategoriesID = new ArrayList<>();

                subCategories.add(cursor.getString(2));
                subCategoriesID.add(cursor.getString(3));
                subCategories.add(cursor.getString(4));
                subCategoriesID.add(cursor.getString(5));
                subCategories.add(cursor.getString(6));
                subCategoriesID.add(cursor.getString(7));
                subCategories.add(cursor.getString(8));
                subCategoriesID.add(cursor.getString(9));
                subCategories.add(cursor.getString(10));
                subCategoriesID.add(cursor.getString(11));


                category.setId(cursor.getString(0));
                category.setCategoryName(cursor.getString(1));
                category.setSubCategories(subCategoriesID);
                category.setSubCategoriesid(subCategories);


            } while (cursor.moveToNext());
        }


        return category;

    }


    //get all required infos

    public ArrayList<OfficeInfo> getAllOffices() {
        ArrayList<OfficeInfo> officeInfos = new ArrayList<>();

        String selectQuery = "SELECT  * FROM " + TABLE_OFFICES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                OfficeInfo officeInfo = new OfficeInfo();
                ArrayList<String> locations = new ArrayList<>();

                locations.add(cursor.getString(3));
                locations.add(cursor.getString(4));
                locations.add(cursor.getString(5));
                locations.add(cursor.getString(6));

                officeInfo.setId(Integer.parseInt(cursor.getString(0)));
                officeInfo.setName(cursor.getString(1));
                officeInfo.setPhone(cursor.getString(2));
                officeInfo.setLocations(locations);
                officeInfo.setShortDetail(cursor.getString(7));
                officeInfo.setType(cursor.getString(8));
                officeInfo.setBusyRating(Integer.parseInt(cursor.getString(9)));

                officeInfos.add(officeInfo);
            } while (cursor.moveToNext());
        }

        return officeInfos;
    }

    public ArrayList<RequiredDocsInfo> getAllrequiredDocInfos() {
        ArrayList<RequiredDocsInfo> requiredDocsInfos = new ArrayList<>();

        String selectQuery = "SELECT  * FROM " + TABLE_DOCUMENTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {

                RequiredDocsInfo docsInfo = new RequiredDocsInfo();
                ArrayList<String> docs = new ArrayList<>();

                docs.add(cursor.getString(1));
                docs.add(cursor.getString(2));
                docs.add(cursor.getString(3));
                docs.add(cursor.getString(4));
                docs.add(cursor.getString(5));
                docs.add(cursor.getString(6));
                docs.add(cursor.getString(7));
                docs.add(cursor.getString(8));
                docs.add(cursor.getString(9));
                docs.add(cursor.getString(10));

                docsInfo.setId(Integer.parseInt(cursor.getString(0)));
                docsInfo.setDocs(docs);
                docsInfo.setMoney(Integer.parseInt(cursor.getString(11)));

                requiredDocsInfos.add(docsInfo);
            } while (cursor.moveToNext());
        }
        return requiredDocsInfos;
    }

    public ArrayList<FAQsInfo> getAllFAQS() {
        ArrayList<FAQsInfo> faQsInfos = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_FAQs;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                FAQsInfo faq = new FAQsInfo();
                ArrayList<String> questions = new ArrayList<>();
                ArrayList<String> answers = new ArrayList<>();

                faq.setId(Integer.parseInt(cursor.getString(0)));

                questions.add(cursor.getString(1));
                questions.add(cursor.getString(2));
                questions.add(cursor.getString(3));
                questions.add(cursor.getString(4));
                questions.add(cursor.getString(5));
                questions.add(cursor.getString(6));
                questions.add(cursor.getString(7));
                questions.add(cursor.getString(8));
                questions.add(cursor.getString(9));
                questions.add(cursor.getString(10));

                answers.add(cursor.getString(11));
                answers.add(cursor.getString(12));
                answers.add(cursor.getString(13));
                answers.add(cursor.getString(14));
                answers.add(cursor.getString(15));
                answers.add(cursor.getString(16));
                answers.add(cursor.getString(17));
                answers.add(cursor.getString(18));
                answers.add(cursor.getString(19));
                answers.add(cursor.getString(20));

                faq.setQuestions(questions);
                faq.setAnswers(answers);

                faQsInfos.add(faq);
            } while (cursor.moveToNext());
        }

        return faQsInfos;
    }


    //get all info count
    public int getCategoryCount() {

        SQLiteDatabase db = this.getReadableDatabase();
        String countQuery = "SELECT  * FROM " + TABLE_CATEGORY;
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();

        return count;
    }

    public int getSubCategoryCount() {

        SQLiteDatabase db = this.getReadableDatabase();
        String countQuery = "SELECT  * FROM " + TABLE_SUB_CATEGORY;
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();

        return count;
    }

    public int getOfficeCount() {

        SQLiteDatabase db = this.getReadableDatabase();
        String countQuery = "SELECT  * FROM " + TABLE_OFFICES;
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();

        return count;
    }

    public int getRequiredDocCount() {
        SQLiteDatabase db = this.getReadableDatabase();
        String countQuery = "SELECT  * FROM " + TABLE_DOCUMENTS;
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();

        return count;
    }

    public int getRequiredFAQCount() {
        SQLiteDatabase db = this.getReadableDatabase();
        String countQuery = "SELECT  * FROM " + TABLE_FAQs;
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();

        return count;
    }


}
