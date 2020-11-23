package inheritance;

public class PhoneApp{
    private String kind, company, call;
    // 전화기종류, 제조사, 통화내역

    public String getKind() {return kind;}
    public void setKind(String kind) {this.kind = kind;}
    public String getCompany() {return company;}
    public void setCompany(String company) {this.company = company;}
    public String getCall() {return call;}
    public void setCall(String call) {this.call = call;}
    @Override
    public String toString() {
        return "Phone [kind=" + kind + ", company=" + company + ", call=" + call + "]";
    }
}
class CelPhone extends PhoneApp{
    private boolean portable;
    private String move;
    
    public boolean isPortable() {return portable;}
    public void setPortable(boolean portable) {this.portable = portable;}
    public String getMove() {return move;}
    public void setMove(String move) {this.move = move;}
    @Override
    public String toString() {
        return "CellPhone [portable=" + portable + ", move=" + move + ", getKind()=" + getKind() + ", getCompany()="
                + getCompany() + ", getCall()=" + getCall() + "]";
    }   
}
class IPhone extends CelPhone{
    private String search;

    public String getSearch() {return search;}
    public void setSearch(String search) {this.search = search;}
    @Override
    public String toString() {
        return "IPhone [search=" + search + ", isPortable()=" + isPortable() + ", getMove()=" + getMove()
                + ", getKind()=" + getKind() + ", getCompany()=" + getCompany() + ", getCall()=" + getCall() + "]";
    }
}
class GalPhone extends IPhone{
    private String pay;
    
    public String getPay() {return pay;}
    public void setPay(String pay) {this.pay = pay;}
    @Override
    public String toString() {
        return "GalPhone [pay=" + pay + ", getSearch()=" + getSearch() + ", isPortable()=" + isPortable()
                + ", getMove()=" + getMove() + ", getKind()=" + getKind() + ", getCompany()=" + getCompany()
                + ", getCall()=" + getCall() + "]";
    }
}