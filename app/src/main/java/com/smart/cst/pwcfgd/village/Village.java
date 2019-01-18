package com.smart.cst.pwcfgd.village;

public class Village {
    String nameVillagesHamlets;
    String numberOfHouseholds;

    public Village(String nameVillagesHamlets, String numberOfHouseholds) {
        this.nameVillagesHamlets = nameVillagesHamlets;
        this.numberOfHouseholds = numberOfHouseholds;
    }

    public String getNameVillagesHamlets() {
        return nameVillagesHamlets;
    }

    public void setNameVillagesHamlets(String nameVillagesHamlets) {
        this.nameVillagesHamlets = nameVillagesHamlets;
    }

    public String getNumberOfHouseholds() {
        return numberOfHouseholds;
    }

    public void setNumberOfHouseholds(String numberOfHouseholds) {
        this.numberOfHouseholds = numberOfHouseholds;
    }
}
