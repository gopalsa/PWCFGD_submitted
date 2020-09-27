package com.smart.cst.pwcfgd.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.smart.cst.pwcfgd.report.PrintSurveyItem;
import com.smart.cst.pwcfgd.report.SurveyItem;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class AppConfig {

    private static Font catFont = new Font(Font.FontFamily.HELVETICA, 14,
            Font.BOLD);

    private static Font responseFont = new Font(Font.FontFamily.HELVETICA, 10,
            Font.BOLD);
    private static Font subFont = new Font(Font.FontFamily.HELVETICA, 8,
            Font.NORMAL);

    public static String ipcloud = "coconutfpo.smartfpo.com/breedcontest/pwcfgd";
    public static String URL_AUDIO_UPLOAD = "http://" + ipcloud + "/audioUpload.php";
    public static String URL_IMAGE_UPLOAD = "http://" + ipcloud + "/fileUpload.php";
    public static String URL_VIDEO_UPLOAD = "http://" + ipcloud + "/videoUpload.php";
    public static String URL_UPLOAD_IMAGES = "http://" + ipcloud + "/multiFileUpload.php";
    public static String URL_CREATE_OFFLINE_SURVEY = "http://" + ipcloud + "/create_offline_survey.php";
    public static String imagePath = "http://coconutfpo.smartfpo.com/breedcontest/pwcfgd/uploads/";


    public static final String studentIdKey = "studentIdKey";
    public static final String staffIdKey = "staffIdKey";
    public static final String mypreference = "mypref";

    public static String URL_CREATE_STAFF = "http://" + ipcloud + "/create_staff.php";
    public static String URL_GET_STAFF = "http://" + ipcloud + "/get_staff.php";
    public static String URL_ALL_STAFF = "http://" + ipcloud + "/get_all_staff.php";
    public static String URL_FORGOT_PASSWORD = "http://" + ipcloud + "/get_forgot_mail.php";

    public static String URL_CREATE_PWCFGD = "http://" + ipcloud + "/pwcfgd.php";
    public static String URL_GET_PWCFGD = "http://" + ipcloud + "/get_pwcfgd.php";

    public static ArrayList<SurveyItem> loadHouseQuestions(Context context) {
        ArrayList<SurveyItem> surveyItems = new ArrayList<>();
        surveyItems.add(new SurveyItem("2.2 Large farmers", "largeFarmers", false));
        surveyItems.add(new SurveyItem("2.3 Medium farmers", "mediumFarmers", false));
        surveyItems.add(new SurveyItem("2.4 Marginal farmers", "marginalFarmers", false));
        surveyItems.add(new SurveyItem("2.5 Traditional Land title holders", "traditionalLandTitleHolders", false, "Male,Female"));
        surveyItems.add(new SurveyItem("2.6 Own Land Cultivators", "ownLandCultivators", false));
        surveyItems.add(new SurveyItem("2.7 Leased Land Cultivators", "leasedLandCultivators", false));
        surveyItems.add(new SurveyItem("2.8 Using Digital Land records (Percent)", "usingDigitalLandRecords", false));
        surveyItems.add(new SurveyItem("2.9 Irrigated Land (Percent)", "irrigatedLand", false));
        surveyItems.add(new SurveyItem("2.10 Rain fed land (Percent)", "rainFedLand", false));
        surveyItems.add(new SurveyItem("3.6 Soil Tested", "soilTested", false));
        surveyItems.add(new SurveyItem("3.7 Soil Health Card", "soilHealthCard", false));
        surveyItems.add(new SurveyItem("3.8 Frequency", "Frequency", false));
        surveyItems.add(new SurveyItem("4.1 Rainfall", "rainfall", false));
        surveyItems.add(new SurveyItem("4.2 Monsoons", "monsoons", false));
        surveyItems.add(new SurveyItem("4.3 Irrigation water available", "irrigationWaterAvailable", false));
        surveyItems.add(new SurveyItem("4.4 River lift irrigation", "riverLiftIrrigation", false));
        surveyItems.add(new SurveyItem("4.5 Canal Irrigation", "canalIrrigation", false));
        surveyItems.add(new SurveyItem("4.6 Tank Irrigation", "tankIrrigation", false));
        surveyItems.add(new SurveyItem("4.7 Well irrigation", "wellIrrigation", false));
        surveyItems.add(new SurveyItem("4.8 Shallow borewell", "shallowBorewell", false));
        surveyItems.add(new SurveyItem("4.9 Medium Bore well", "mediumBoreWell", false));
        surveyItems.add(new SurveyItem("4.10 Deep Bore well", "deepBoreBoreWell", false));
        surveyItems.add(new SurveyItem("4.11 Diesel /Kerosene pumps", "dieselKerosenePumps", false));
        surveyItems.add(new SurveyItem("4.12 Electric pumps", "electricPumps", false));
        surveyItems.add(new SurveyItem("4.13 Solar Pumps", "solarPumps", false));
        surveyItems.add(new SurveyItem("4.14 Flood irrigation", "floodIrrigation", false));
        surveyItems.add(new SurveyItem("4.15 Drip irrigation", "dripIrrigation", false));
        surveyItems.add(new SurveyItem("4.16 Sprinkler irrigation", "sprinklerIrrigation", false));
        surveyItems.add(new SurveyItem("4.17 Rain gun irrigation", "rainGunIrrigation", false));
        surveyItems.add(new SurveyItem("6.1.1 Tractor", "tractor", false));
        surveyItems.add(new SurveyItem("6.1.2 Tiller", "tiller", false));
        surveyItems.add(new SurveyItem("6.1.3 Irrigation", "irrigation", false));
        surveyItems.add(new SurveyItem("6.1.4 Harvester", "harvester", false));
        surveyItems.add(new SurveyItem("6.1.5 Trasher", "trasher", false));
        surveyItems.add(new SurveyItem("6.1.6 Dryer", "dryer", false));
        surveyItems.add(new SurveyItem("6.1.7 Ware House /Cold storage monthly rental", "coldStorageMonthlyRental", false));
        surveyItems.add(new SurveyItem("7.1 How do you get information on agricultural best practices", "informationAgriBestPractices", false));
        surveyItems.add(new SurveyItem("7.2 Who provides guidance on farming practices", "whoProvidesGuidance", false));
        surveyItems.add(new SurveyItem("7.3 Trainings participated in last one year", "trainingsParticipated", false));
        surveyItems.add(new SurveyItem("7.4 Do you use weather information for ploughing or planting or irrigation or harvest", "useWeatherInformation", false));
        surveyItems.add(new SurveyItem("7.5 If yes what was the source", "ifYesWhatSource", false));
        surveyItems.add(new SurveyItem("8.1 Investment for cropping", "investmentForCropping", false));
        surveyItems.add(new SurveyItem("8.2 Own Kisan Credit card", "ownKisanCreditCard", false));
        surveyItems.add(new SurveyItem("8.4 Loan Repayment", "loanRepayment", false, "Own,Hire"));
        surveyItems.add(new SurveyItem("9.2 What is major source of Information on Current price of crop?", "sourceInformationCurrent", false, "Own,Hire"));
        surveyItems.add(new SurveyItem("9.3 Time of sale", "timeOfSale", false));
        surveyItems.add(new SurveyItem("9.4 Storage Systems", "storageSystems", false));
        surveyItems.add(new SurveyItem("9.5 Storage Items", "storageItems", false));
        surveyItems.add(new SurveyItem("9.6.1.4 Fruits Price", "sellCropsFruitsPrice", false));
        surveyItems.add(new SurveyItem("9.6.1.5 Fruits Payment", "sellCropsFruitsPayment", false));
        surveyItems.add(new SurveyItem("9.6.2.7 Cereals Price", "sellCropsCerealsPrice", false));
        surveyItems.add(new SurveyItem("9.6.2.8 Cereals Payment", "sellCropsCerealsPayment", false));
        surveyItems.add(new SurveyItem("9.6.3.5 Vegetables Price", "sellCropsVegetablesPrice", false));
        surveyItems.add(new SurveyItem("9.6.3.6 Vegetables Payment", "sellCropsVegetablesPayment", false));
        surveyItems.add(new SurveyItem("10.1.1 Income from Crops", "incomeFromCrops", false));
        surveyItems.add(new SurveyItem("10.1.2 Income from Livestock", "incomeFromLivestock", false));
        surveyItems.add(new SurveyItem("10.1.3 Income from Agri labour", "incomeFromAgriLabour", false));
        surveyItems.add(new SurveyItem("10.1.4 Income from Migration labour", "incomeFromMigrationLabour", false));
        surveyItems.add(new SurveyItem("10.1.5 Income From Service", "incomeFromService", false));
        surveyItems.add(new SurveyItem("10.1.6 Income from shop /trade", "incomeFromShopTrade", false));
        surveyItems.add(new SurveyItem("10.2 Three meals of food", "threeMealsOfFood", false));
        surveyItems.add(new SurveyItem("10.3.1 Land preparation", "landPreparation", false));
        surveyItems.add(new SurveyItem("10.3.2 Seeds", "seeds", false));
        surveyItems.add(new SurveyItem("10.3.3 Fertilizer", "fertilizer", false));
        surveyItems.add(new SurveyItem("10.3.4 Pesticides", "pesticides", false));
        surveyItems.add(new SurveyItem("10.3.5 Irrigation", "irrigationExpan", false));
        surveyItems.add(new SurveyItem("10.3.6 Weeding", "weeding", false));
        surveyItems.add(new SurveyItem("10.3.7 Harvesting", "harvesting", false));
        surveyItems.add(new SurveyItem("10.3.8 Cleaning,Sorting,Packing", "cleaningSortingPacking", false));
        surveyItems.add(new SurveyItem("10.3.9 Transportation", "transportation", false));
        surveyItems.add(new SurveyItem("10.3.10 Storage", "storage", false));
        surveyItems.add(new SurveyItem("10.4.1 Milking cow", "milkingCow", false));
        surveyItems.add(new SurveyItem("10.4.2 Sheep & Goats", "sheepGoats", false));
        surveyItems.add(new SurveyItem("10.4.3 Backyard Poultry", "backyardPoultry", false));
        surveyItems.add(new SurveyItem("10.3.4 Aquaculture pond", "aquaculturePond", false));
        surveyItems.add(new SurveyItem("10.4.5 Tractors", "tractors", false));
        surveyItems.add(new SurveyItem("10.4.6 Tillers", "tillers", false));
        surveyItems.add(new SurveyItem("10.4.7 Harvesters", "harvesters", false));

        return surveyItems;
    }


    public static ArrayList<SurveyItem> loadLineQuestions(Context context) {
        ArrayList<SurveyItem> surveyItems = new ArrayList<>();
        surveyItems.add(new SurveyItem("2.2,2.3,&2.4",
                "largeFarmers,mediumFarmers,marginalFarmers",
                "Larger Farmers,Medium Farmers,Marginal Farmers", false));
        surveyItems.add(new SurveyItem("2.6,2.6",
                "ownLandCultivators,leasedLandCultivators",
                "Own Land Cultivators,Leased Land Cultivators", false));
        surveyItems.add(new SurveyItem("2.9,2.10",
                "irrigatedLand,rainFedLand",
                "Irrigated Land,Rain fed land", false));
        surveyItems.add(new SurveyItem("4.4,4.5,4.6,4.7,4.8,4.9,4.10",
                "riverLiftIrrigation,canalIrrigation,tankIrrigation,wellIrrigation,shallowBorewell,mediumBoreWell,deepBoreBoreWell",
                "River lift irrigation,Canal Irrigation,Tank Irrigation,Well irrigation,Medium Bore well,Deep Bore well", false));
        surveyItems.add(new SurveyItem("4.11,4.12,4.13",
                "dieselKerosenePumps,electricPumps,solarPumps",
                "Diesel /Kerosene pumps,Electric pumps,Solar Pumps", false));
        surveyItems.add(new SurveyItem("4.14,4.15,4.16,4.17",
                "floodIrrigation,dripIrrigation,sprinklerIrrigation,rainGunIrrigation",
                "Flood irrigation,Drip irrigation,Sprinkler irrigation,Rain gun irrigation", false));
        return surveyItems;
    }


    public static String URL_GET_All_SURVEY = "http://" + ipcloud + "/get_all_uba_report.php";
    public static String URL_GET_USER_SURVEY = "http://" + ipcloud + "/get_user_survey_report.php";
    public static String URL_CREATE_SURVEYANS = "http://" + ipcloud + "/create_uba_ans.php";
    public static String URL_GET_All_SURVEYANS = "http://" + ipcloud + "/get_all_uba_ans.php";

    public static Bitmap getBitmapFromView(View view, int totalHeight, int totalWidth) {

        Bitmap returnedBitmap = Bitmap.createBitmap(totalWidth, totalHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(returnedBitmap);
        Drawable bgDrawable = view.getBackground();
        if (bgDrawable != null)
            bgDrawable.draw(canvas);
        else
            canvas.drawColor(Color.WHITE);
        view.draw(canvas);
        return returnedBitmap;
    }

    public static void addMetaData(Document document) {
        document.addTitle("My first PDF");
        document.addSubject("Using iText");
        document.addKeywords("Java, PDF, iText");
        document.addAuthor("Lars Vogel");
        document.addCreator("Lars Vogel");
    }

    public static void addContent(Document document, PrintSurveyItem[] printSurveyItems) throws Exception {


        for (int i = 0; i < printSurveyItems.length; i++) {
            if (printSurveyItems[i] != null && printSurveyItems[i].getBitmap() != null) {


                if (i != 0) {
                    document.newPage();
                }
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                printSurveyItems[i].getBitmap().compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();

                Image convertBmp = Image.getInstance(byteArray);
                convertBmp.setAlignment(Element.ALIGN_CENTER);


                PdfPTable table1 = new PdfPTable(1);
                table1.setWidthPercentage(100);
                table1.setWidths(new int[]{1});
                table1.addCell(createTextCell(printSurveyItems[i].getQuestion(),
                        catFont));
                table1.addCell(createImageCell(convertBmp));
                table1.addCell(createTextCell(printSurveyItems[i].getSubtitle().replaceAll("\n", " "),
                        responseFont));

                table1.addCell(createTextCell("Relevance",
                        catFont));
                if (printSurveyItems[i].getRelevance().length() > 0) {
                    table1.addCell(createTextCell(printSurveyItems[i].getRelevance(),
                            subFont));
                } else {
                    table1.addCell(createTextCell("Relevance appear here",
                            subFont));
                }
                table1.addCell(createTextCell("Inference",
                        catFont));

                if (printSurveyItems[i].getInference().length() > 0) {
                    table1.addCell(createTextCell(printSurveyItems[i].getInference(),
                            subFont));
                } else {
                    table1.addCell(createTextCell("Inference appear here",
                            subFont));
                }

                table1.setKeepTogether(true);

                document.add(table1);


            }

        }


    }

    public static PdfPCell createImageCell(Image path) throws DocumentException, IOException {
        PdfPCell cell = new PdfPCell(path, true);
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setFixedHeight(400);
        return cell;
    }

    public static PdfPCell createTextCell(String text, Font font) throws DocumentException, IOException {
        PdfPCell cell = new PdfPCell();
        Paragraph p = new Paragraph(text, font);
        p.setAlignment(Element.ALIGN_LEFT);
        cell.addElement(p);
        cell.setVerticalAlignment(Element.ALIGN_BOTTOM);
        cell.setBorder(Rectangle.NO_BORDER);
        return cell;
    }
}
