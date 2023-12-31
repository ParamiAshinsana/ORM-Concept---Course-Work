package lk.ijse.dto.tm;

public class RoomTM {
    private String roomTypeId;
    private String type;
    private Double keyMoney;
    private int qty;

    public RoomTM() {
    }

    public RoomTM(String roomTypeId, String type, Double keyMoney, int qty) {
        this.roomTypeId = roomTypeId;
        this.type = type;
        this.keyMoney = keyMoney;
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "RoomTM{" +
                "roomTypeId='" + roomTypeId + '\'' +
                ", type='" + type + '\'' +
                ", keyMoney=" + keyMoney +
                ", qty=" + qty +
                '}';
    }

    public String getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(String roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getKeyMoney() {
        return keyMoney;
    }

    public void setKeyMoney(Double keyMoney) {
        this.keyMoney = keyMoney;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
