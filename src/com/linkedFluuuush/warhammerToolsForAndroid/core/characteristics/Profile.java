package com.linkedFluuuush.warhammerToolsForAndroid.core.characteristics;

/**
 * Created with IntelliJ IDEA.
 * User: Linked
 * Date: 12/11/13
 * Time: 15:30
 * To change this template use File | Settings | File Templates.
 */
public class Profile {
    private int ws;
    private int bs;
    private int s;
    private int t;
    private int ag;
    private int intel;
    private int wp;
    private int fel;

    private int a;
    private int w;
    private int sb;
    private int tb;
    private int m;
    private int mag;
    private int ip;
    private int fp;

    public Profile(int ws, int bs, int s, int t, int ag, int intel, int wp, int fel,
                   int a, int w, int sb, int tb, int m, int mag, int ip, int fp) {
        this.ws = ws;
        this.bs = bs;
        this.s = s;
        this.t = t;
        this.ag = ag;
        this.intel = intel;
        this.wp = wp;
        this.fel = fel;
        this.a = a;
        this.w = w;
        this.sb = sb;
        this.tb = tb;
        this.m = m;
        this.mag = mag;
        this.ip = ip;
        this.fp = fp;
    }

    public Profile(int ws, int bs, int s, int t, int ag, int intel, int wp, int fel,
                   int a, int w, int m, int mag) {
        this.ws = ws;
        this.bs = bs;
        this.s = s;
        this.t = t;
        this.ag = ag;
        this.intel = intel;
        this.wp = wp;
        this.fel = fel;
        this.a = a;
        this.w = w;
        this.sb = s / 10;
        this.tb = t / 10;
        this.m = m;
        this.mag = mag;
        this.ip = 0;
        this.fp = 0;
    }

    public Profile(int ws, int bs, int s, int t, int ag, int intel, int wp, int fel,
                   int w, int m, int fp) {
        this.ws = ws;
        this.bs = bs;
        this.s = s;
        this.t = t;
        this.ag = ag;
        this.intel = intel;
        this.wp = wp;
        this.fel = fel;
        this.a = 1;
        this.w = w;
        this.sb = s / 10;
        this.tb = t / 10;
        this.m = m;
        this.mag = 0;
        this.ip = 0;
        this.fp = fp;
    }

    public Profile(int ws, int bs, int s, int t, int ag, int intel, int wp, int fel, int m) {
        this.ws = ws;
        this.bs = bs;
        this.s = s;
        this.t = t;
        this.ag = ag;
        this.intel = intel;
        this.wp = wp;
        this.fel = fel;
        this.a = 1;
        this.w = 0;
        this.sb = s / 10;
        this.tb = t / 10;
        this.m = m;
        this.mag = 0;
        this.ip = 0;
        this.fp = 0;
    }

    public int getWs() {
        return ws;
    }

    public void setWs(int ws) {
        this.ws = ws;
    }

    public int getBs() {
        return bs;
    }

    public void setBs(int bs) {
        this.bs = bs;
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }

    public int getAg() {
        return ag;
    }

    public void setAg(int ag) {
        this.ag = ag;
    }

    public int getIntel() {
        return intel;
    }

    public void setIntel(int intel) {
        this.intel = intel;
    }

    public int getWp() {
        return wp;
    }

    public void setWp(int wp) {
        this.wp = wp;
    }

    public int getFel() {
        return fel;
    }

    public void setFel(int fel) {
        this.fel = fel;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getSb() {
        return sb;
    }

    public void setSb(int sb) {
        this.sb = sb;
    }

    public int getTb() {
        return tb;
    }

    public void setTb(int tb) {
        this.tb = tb;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getMag() {
        return mag;
    }

    public void setMag(int mag) {
        this.mag = mag;
    }

    public int getIp() {
        return ip;
    }

    public void setIp(int ip) {
        this.ip = ip;
    }

    public int getFp() {
        return fp;
    }

    public void setFp(int fp) {
        this.fp = fp;
    }

    @Override
    public String toString(){
        String res = "Caratéristiques\n";
        res += "CC\tCT\tF\tE\tAg\tInt\tFM\tSoc\n";
        res += this.getWs() + "\t" + this.getBs() + "\t" + this.getS() + "\t" + this.getT() + "\t" + this.getAg() +
                "\t" + this.getIntel() + "\t" + this.getWp() + "\t" + this.getFel() + "\n";
        res += "A\tB\tBF\tBE\tM\tMag\tPF\tPD\n";
        res += this.getA() + "\t" + this.getW() + "\t" + this.getSb() + "\t" + this.getTb() + "\t" + this.getM() +
                "\t" + this.getMag() + "\t" + this.getIp() + "\t" + this.getFp() + "\n";
        return res;
    }

    @Override
    public Profile clone(){
        return new Profile(this.getWs(),this.getBs(),this.getS(),this.getT(),this.getAg(),this.getIntel(),this.getWp(),
                this.getFel(),this.getA(),this.getW(),this.getSb(),this.getTb(),this.getM(),this.getMag(),this.getIp(),
                this.getFp());
    }
}
