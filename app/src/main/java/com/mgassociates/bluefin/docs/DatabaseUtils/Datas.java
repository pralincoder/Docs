package com.mgassociates.bluefin.docs.DatabaseUtils;

import android.content.Context;

import com.mgassociates.bluefin.docs.Models.Category;
import com.mgassociates.bluefin.docs.Models.SubCategory;

import java.util.ArrayList;

/**
 * Created by reddevil on 1/29/18.
 */

public class Datas {

    Context context;

    public Datas(Context context) {
        this.context = context;
    }

    public  Datas(){

    }

    public ArrayList<SubCategory> getSubCategoryDatas(){
        ArrayList<SubCategory> subCategoryArrayList=new ArrayList<>();


        ArrayList<String> passportLocations = new ArrayList<>();
        passportLocations.add("Kantipath");
        passportLocations.add("Babarmal");
        passportLocations.add(null);
        passportLocations.add(null);
        passportLocations.add(null);
        passportLocations.add(null);

        ArrayList<String> passportSteps = new ArrayList<>();
        for (int i = 0; i < 15; i++){
            passportSteps.add(null);

        }

        ArrayList<String> passportDocs = new ArrayList<>();
        passportDocs.add("2 Copies of Form");
        passportDocs.add("Citizenship Certificate");
        passportDocs.add("2 Photocopies of Citizenship Certificate");
        passportDocs.add("3 MRP photos");
        passportDocs.add("Bank Voucher of Rs 5000 on NMB Bank");
        passportDocs.add("Sifaris from District Administration Office if he/she is from same district.");
        passportDocs.add("For applicant from other Districts who have moved to another district, Original Migration Certificate,House Map Pass Certificate and Citizenship Certificate from associated District and photocopy of each.");
        passportDocs.add("For applicant from other Districts or Married, Original Marriage Certificate,Photocopy of Husband's Citizenship and Citizenship record from associated District.");
        passportDocs.add("For goverment officers and their family applying in another districts,Recomendation letter, photocopy of Identity Card, Citizenship record from associated District");
        passportDocs.add(null);

        ArrayList<String> kidsPassportDocs = new ArrayList<>();
        kidsPassportDocs.add("Birth Certificate of Children");
        kidsPassportDocs.add("Citizenship Certificate of Father");
        kidsPassportDocs.add("Citizenship Certificate of Mother");
        kidsPassportDocs.add("Photocopies of Citizenship Certificate of Mother's and Father's");
        kidsPassportDocs.add("3 MRP photos");
        kidsPassportDocs.add("Bank Voucher of Rs 5000 on NMB Bank");
        kidsPassportDocs.add(null);
        kidsPassportDocs.add(null);
        kidsPassportDocs.add(null);
        kidsPassportDocs.add(null);

        ArrayList<String> renualPassportDocs = new ArrayList<>();
        renualPassportDocs.add("Passport and its photocopy");
        renualPassportDocs.add("Citizenship and its photocopy");
        renualPassportDocs.add("Bank Voucher of Rs 5000 on NMB Bank");
        renualPassportDocs.add(null);
        renualPassportDocs.add(null);
        renualPassportDocs.add(null);
        renualPassportDocs.add(null);
        renualPassportDocs.add(null);
        renualPassportDocs.add(null);
        renualPassportDocs.add(null);

        SubCategory normalPassport = new SubCategory("norpp", "Normal Passport", "01445484", "passport@gov.np","http://www.nepalpassport.gov.np", passportLocations, 5000, passportSteps, passportDocs);
        SubCategory kidsPassport=new SubCategory("kidpp","Normal Passport for kids","01445484","passport@gov.np","http://www.nepalpassport.gov.np",passportLocations,2500,passportSteps,kidsPassportDocs);
        SubCategory urgentPassport=new SubCategory("urgpp","Urgent Passport","01445484","passport@gov.np","http://www.nepalpassport.gov.np",passportLocations,15000,passportSteps,passportDocs);
        SubCategory renewPassport=new SubCategory("rengpp","Renual of  Passport","01445484","passport@gov.np","http://www.nepalpassport.gov.np",passportLocations,5000,passportSteps,renualPassportDocs);

        subCategoryArrayList.add(normalPassport);
        subCategoryArrayList.add(kidsPassport);
        subCategoryArrayList.add(urgentPassport);
        subCategoryArrayList.add(renewPassport);


        //license

        ArrayList<String> licenseLocations=new ArrayList<>();
        licenseLocations.add("Ekantakuna");
        licenseLocations.add("Thulo Varyang");
        licenseLocations.add("Chabahil");
        licenseLocations.add("Naikap");
        licenseLocations.add("Jagati");
        licenseLocations.add(null);

        ArrayList<String> licenseSteps=new ArrayList<>();
        licenseSteps.add("[Online] Go to the website of Department of Transport Management ");
        licenseSteps.add("[Online] Tap on the  blue button \"Online Driving License Form\"");
        licenseSteps.add("[Online] Enter your citizenship number and the category of license you are applying for ");
        licenseSteps.add("[Online] Proceed and fill up every details of the form and submit");
        licenseSteps.add("[At office] One need to visit Office forPhotograph, Biometric test and Payment of Revenue( Rajashwa) on the date mentioned after registration in the online form.");
        licenseSteps.add("[At office] One need to submit Original Driving License with ticket and photocopy of citizenship certificate and  pay the revenue amount  for the renewal of existing Lisence( every five years)");
        licenseSteps.add("[At office] One need to submit application with police report mentioning the License number for the renewal process");
        licenseSteps.add(null);
        licenseSteps.add(null);
        licenseSteps.add(null);
        licenseSteps.add(null);
        licenseSteps.add(null);
        licenseSteps.add(null);
        licenseSteps.add(null);
        licenseSteps.add(null);

        ArrayList<String> renewalLicenseStep=new ArrayList<>();
        for (int i = 0; i < 15; i++){
            renewalLicenseStep.add(null);
        }


        ArrayList<String> newlicenseDocs=new ArrayList<>();
        newlicenseDocs.add("Original Citizenship Certificate");
        newlicenseDocs.add("Photocopy Citizenship Certificate");
        newlicenseDocs.add("Blood Group Card");
        newlicenseDocs.add("Medical Report");
        newlicenseDocs.add("Training Certificate (in case of 4 Wheelers only)");
        newlicenseDocs.add(null);
        newlicenseDocs.add(null);
        newlicenseDocs.add(null);
        newlicenseDocs.add(null);
        newlicenseDocs.add(null);

        ArrayList<String> renewallicenseDocs=new ArrayList<>();
        renewallicenseDocs.add("Original License and its photocopy");
        renewallicenseDocs.add("Original Citizenship Certificate and its photocopy");
        renewallicenseDocs.add("Medical Report");
        renewallicenseDocs.add(null);
        renewallicenseDocs.add(null);
        renewallicenseDocs.add(null);
        renewallicenseDocs.add(null);
        renewallicenseDocs.add(null);
        renewallicenseDocs.add(null);
        renewallicenseDocs.add(null);

        ArrayList<String> lostlicenseDocs=new ArrayList<>();
        lostlicenseDocs.add("Application of Remake");
        lostlicenseDocs.add("Police report of lost and not found after 35 days  of official announcement of loss ");
        lostlicenseDocs.add("Photocopy of License(if you have)");
        lostlicenseDocs.add("License number of Lost License");
        lostlicenseDocs.add(null);
        lostlicenseDocs.add(null);
        lostlicenseDocs.add(null);
        lostlicenseDocs.add(null);
        lostlicenseDocs.add(null);
        lostlicenseDocs.add(null);


        SubCategory newLicense=new SubCategory("newlc","New License","01454545","license@gov.np","http://www.dotm.gov.np",licenseLocations,1500,licenseSteps,newlicenseDocs);
        SubCategory renewalLicense=new SubCategory("renlc","Renewal Of License","01454545","license@gov.np","license@gov.np",licenseLocations,1500,renewalLicenseStep,renewallicenseDocs);
        SubCategory lostLicense=new SubCategory("loslc","Lost License","01454545","license@gov.np","license@gov.np",licenseLocations,1500,renewalLicenseStep,lostlicenseDocs);


        subCategoryArrayList.add(newLicense);
        subCategoryArrayList.add(renewalLicense);
        subCategoryArrayList.add(lostLicense);

        //voters card
        ArrayList<String> votersLocations=new ArrayList<>();
        votersLocations.add("Babarmahal");
        votersLocations.add(null);
        votersLocations.add(null);
        votersLocations.add(null);
        votersLocations.add(null);
        votersLocations.add(null);

        ArrayList<String>  votersSteps=new ArrayList<>();
        votersSteps.add("In every Metropolitian city / Municipality / V.D.C 's the authorized  administrative officer register the eligible candidates( 18 years and above) for voter's list on announced date and time by the Commision" +
                ".One need to visit the office with the original citizenship card for the biometric registration process\n");
        for (int i = 0; i < 14; i++){
            votersSteps.add(null);
        }
        ArrayList<String> votersDocs=new ArrayList<>();
        votersDocs.add("Original Citizenship Certificate");
        votersDocs.add("Photocopy of Citizenship Certificate");
        votersDocs.add("For changin the voting district, House map certificate of currently living house");
        votersDocs.add(null);
        votersDocs.add(null);
        votersDocs.add(null);
        votersDocs.add(null);
        votersDocs.add(null);
        votersDocs.add(null);
        votersDocs.add(null);

        SubCategory registerVotersCard=new SubCategory("regvc","Voters Card Registration","01515151","voters@gov.np","http://www.election.gov.np",votersLocations,0,votersSteps,votersDocs);
        subCategoryArrayList.add(registerVotersCard);

        //blue book
        ArrayList<String> bluebookLocations=new ArrayList<>();
        bluebookLocations.add("Ekantakuna");
        bluebookLocations.add("Thulo Varyang");
        bluebookLocations.add("Chabahil");
        bluebookLocations.add("Naikap");
        bluebookLocations.add("Jagati");
        bluebookLocations.add(null);

        ArrayList<String> bluebookSteps=new ArrayList<>();
        for (int i = 0; i < 15; i++){
            bluebookSteps.add(null);
        }


        ArrayList<String> newbluebookDocs=new ArrayList<>();
        newbluebookDocs.add("Original Citizenship Certificate");
        newbluebookDocs.add("Photocopy Citizenship Certificate");
        newbluebookDocs.add("Paper of your Vechicle");
        newbluebookDocs.add("Insurance paper of minimum 1 year");
        newbluebookDocs.add(null);
        newbluebookDocs.add(null);
        newbluebookDocs.add(null);
        newbluebookDocs.add(null);
        newbluebookDocs.add(null);
        newbluebookDocs.add(null);

        ArrayList<String> renewbluebookDocs=new ArrayList<>();
        renewbluebookDocs.add("Current Bluebook");
        renewbluebookDocs.add("Insurance Paper of minimum 1 year");
        renewbluebookDocs.add("Voucher of payment of tax");
        renewbluebookDocs.add(null);
        renewbluebookDocs.add(null);
        renewbluebookDocs.add(null);
        renewbluebookDocs.add(null);
        renewbluebookDocs.add(null);
        renewbluebookDocs.add(null);
        renewbluebookDocs.add(null);

        ArrayList<String> lostbluebookDocs=new ArrayList<>();
        lostbluebookDocs.add("Application of Remake");
        lostbluebookDocs.add("Police report of lost and not found after 35 days  of official announcement of loss ");
        lostbluebookDocs.add("Photocopy of Blubook(if you have)");
        lostbluebookDocs.add("Vechicle detail with paper");
        lostbluebookDocs.add(null);
        lostbluebookDocs.add(null);
        lostbluebookDocs.add(null);
        lostbluebookDocs.add(null);
        lostbluebookDocs.add(null);
        lostbluebookDocs.add(null);


        SubCategory newBlueBook=new SubCategory("newbb","New BlueBook","01454545","bluebook@gov.np","license@gov.np",bluebookLocations,1500,bluebookSteps,newbluebookDocs);
        SubCategory renewalBluebook=new SubCategory("renbb","Renewal Of Bluebook","01454545","bluebook@gov.np","license@gov.np",bluebookLocations,1500,bluebookSteps,renewbluebookDocs);
        SubCategory lostBluebook=new SubCategory("losbb","Lost Bluebook","01454545","bluebook@gov.np","license@gov.np",bluebookLocations,1500,bluebookSteps,lostbluebookDocs);

        subCategoryArrayList.add(newBlueBook);
        subCategoryArrayList.add(renewalBluebook);
        subCategoryArrayList.add(lostBluebook);

        ArrayList<String> malpotLocations=new ArrayList<>();
        malpotLocations.add("Tokha");
        malpotLocations.add("Kalanki");
        malpotLocations.add("Baneshor");
        malpotLocations.add("Baluwatar");
        malpotLocations.add(null);
        malpotLocations.add(null);

        ArrayList<String> landpassSteps=new ArrayList<>();
        for (int i = 0; i < 15; i++){
            landpassSteps.add(null);
        }


        ArrayList<String> landpassDocs=new ArrayList<>();
        landpassDocs.add("Citizenship Certificate original and photocopy of Buyer");
        landpassDocs.add("Citizenship Certificate original and photocopy of Seller");
        landpassDocs.add("4 passport sized photo of buyer");
        landpassDocs.add("Lalpurja of Land.");
        landpassDocs.add("Paper of Kittani");
        landpassDocs.add("Tax paid paper of Current fiscal year.");
        landpassDocs.add(null);
        landpassDocs.add(null);
        landpassDocs.add(null);
        landpassDocs.add(null);

        ArrayList<String> namsariDocs=new ArrayList<>();
        namsariDocs.add("Ownership Certificate of land");
        namsariDocs.add("Death Certificate in case of death");
        namsariDocs.add("Citizenship certificate original and photocopy of old owner");
        namsariDocs.add("Citizenship certificate original and photocopy of new owner");
        namsariDocs.add("4 passport sized photo of new owner.");
        namsariDocs.add("Relationship Certificate(Nata Praman Patra)");
        namsariDocs.add("Tax Paid paper of current fiscal year");
        namsariDocs.add(null);
        namsariDocs.add(null);
        namsariDocs.add(null);

        ArrayList<String> fraudDocs=new ArrayList<>();
        fraudDocs.add("Lalpurja");
        fraudDocs.add("Map of the land(Jagga ko naksa)");
        fraudDocs.add("Correction in name,surname and others");
        fraudDocs.add("Ownership Certificate of assets");
        fraudDocs.add("Municipality/V.D.C's recommendation letter(sifarish patra)");
        fraudDocs.add("Tax paid paper of current fiscal year");
        fraudDocs.add("Application  based on Lawyer(napi )'s opinion(Napi karyalayako raya sahit ko prawidhik pratibedhan)");
        fraudDocs.add("Citizenship certificate original and photocopy");
        fraudDocs.add(null);
        fraudDocs.add(null);

        SubCategory landPassMalpot=new SubCategory("landm","Land Pass","01454545","malpot@gov.np","http://www.molrm.gov.np/",malpotLocations,0,landpassSteps,landpassDocs);
        SubCategory namsariMalpot=new SubCategory("namsm","Namsari of Assets","01454545","malpot@gov.np","http://www.molrm.gov.np/",malpotLocations,0,landpassSteps,namsariDocs);
        SubCategory housePassMalpot=new SubCategory("homem","House Pass","01454545","malpot@gov.np","http://www.molrm.gov.np/",malpotLocations,0,landpassSteps,landpassDocs);
        SubCategory fraudMalpot=new SubCategory("fradm","Fraud","01454545","malpot@gov.np","http://www.molrm.gov.np/",malpotLocations,0,landpassSteps,fraudDocs);

        subCategoryArrayList.add(landPassMalpot);
        subCategoryArrayList.add(namsariMalpot);
        subCategoryArrayList.add(housePassMalpot);
        subCategoryArrayList.add(fraudMalpot);



        return subCategoryArrayList;


    }
     public ArrayList<Category> getCategoryDatas(){

        ArrayList<Category> categoryArrayList=new ArrayList<>();

         ArrayList<String> malpotCategory = new ArrayList<>();
         malpotCategory.add("Land Pass");
         malpotCategory.add("Namsari");
         malpotCategory.add("Fraud");
         malpotCategory.add("House Pass");
         malpotCategory.add(null);

         ArrayList<String> malpotCategoryIds=new ArrayList<>();
         malpotCategoryIds.add("landm");
         malpotCategoryIds.add("namsm");
         malpotCategoryIds.add("homem");
         malpotCategoryIds.add("fradm");
         malpotCategoryIds.add(null);

         ArrayList<String> licenseCategory = new ArrayList<>();
         licenseCategory.add("New License");
         licenseCategory.add("Renewal Of License");
         licenseCategory.add("Lost License");
         licenseCategory.add(null);
         licenseCategory.add(null);

         ArrayList<String> licenseCategoryIds=new ArrayList<>();
         licenseCategoryIds.add("newlc");
         licenseCategoryIds.add("renlc");
         licenseCategoryIds.add("loslc");
         licenseCategoryIds.add(null);
         licenseCategoryIds.add(null);

         ArrayList<String> passportCategory = new ArrayList<>();
         passportCategory.add("Normal Passport");
         passportCategory.add("Normal Passport for Kids");
         passportCategory.add("Urgent Passport");
         passportCategory.add("Renewal Of Passport");
         passportCategory.add(null);

         ArrayList<String> passportCategoryIds=new ArrayList<>();
         passportCategoryIds.add("norpp");
         passportCategoryIds.add("kidpp");
         passportCategoryIds.add("urgpp");
         passportCategoryIds.add("renpp");
         passportCategoryIds.add(null);

         ArrayList<String> votersCardCategory = new ArrayList<>();
         votersCardCategory.add("Registration of Voter's Card");
         votersCardCategory.add(null);
         votersCardCategory.add(null);
         votersCardCategory.add(null);
         votersCardCategory.add(null);

         ArrayList<String> votersCardCategoryIds=new ArrayList<>();
         votersCardCategoryIds.add("regvc");
         votersCardCategoryIds.add(null);
         votersCardCategoryIds.add(null);
         votersCardCategoryIds.add(null);
         votersCardCategoryIds.add(null);

         ArrayList<String> bluebookCategory = new ArrayList<>();
         bluebookCategory.add("New Blue Book");
         bluebookCategory.add("Lost Blue Book");
         bluebookCategory.add("Remake Of Blue Book");
         bluebookCategory.add(null);
         bluebookCategory.add(null);

         ArrayList<String> bluebookCategoryIds=new ArrayList<>();
         bluebookCategoryIds.add("newbb");
         bluebookCategoryIds.add("renbb");
         bluebookCategoryIds.add("losbb");
         bluebookCategoryIds.add(null);
         bluebookCategoryIds.add(null);


         Category malpot = new Category("m", "Malpot Karyalaya", malpotCategoryIds,malpotCategory);
         Category license = new Category("lc", "License",licenseCategoryIds,licenseCategory);
         Category passport = new Category("pp", "Passport",passportCategoryIds,passportCategory);
         Category votersCard = new Category("vc", "Voter's Card",votersCardCategoryIds,votersCardCategory);
         Category bluebook = new Category("bb", "Blue Book",bluebookCategoryIds,bluebookCategory);


         categoryArrayList.add(malpot);
         categoryArrayList.add(license);
         categoryArrayList.add(passport);
         categoryArrayList.add(votersCard);
         categoryArrayList.add(bluebook);


         return categoryArrayList;

     }

}
