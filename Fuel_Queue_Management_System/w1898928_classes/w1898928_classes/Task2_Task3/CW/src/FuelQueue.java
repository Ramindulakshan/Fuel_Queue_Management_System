
public class FuelQueue {
    private String firstName;
    private String secondName;
    private String vehicleNo;
    private int litersRequired;

    public FuelQueue(String firstName, String secondName, String vehicleNo, int litersRequired) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.vehicleNo = vehicleNo;
        this.litersRequired = litersRequired;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public int getLitersRequired() {
        return litersRequired;
    }

    public void setLitersRequired(int litersRequired) {
        this.litersRequired = litersRequired;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public FuelQueue(){
        this.firstName = "firstName";
        this.secondName = "secondName";
        this.litersRequired = 0;
        this.vehicleNo = "abc";
    }

    public boolean isEmpty() {
        return this.firstName == null;
    }

}
