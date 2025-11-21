package org.stjernemix.clickerplugin.playerData;

public class PlayerData {
    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }

    public int getRebirths() {
        return rebirths;
    }

    public void setRebirths(int rebirths) {
        this.rebirths = rebirths;
    }

    private int money;
    private int multiplier;
    private int rebirths;
    private boolean adminBypass;

    public boolean getAdminBypass() {
        return adminBypass;
    }

    public void setAdminBypass(boolean adminBypass) {
        this.adminBypass = adminBypass;
    }
}
