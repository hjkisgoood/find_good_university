package sjk.com.demo.entity;



import jakarta.persistence.*;


@Entity
public class Dormitories {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long dormitoryId;
        private Long universityId;
        private boolean hasPrivateBathroom;
        private boolean hasAirConditioning;

        private boolean hasBunkBedDesk;

        private int roommateCount;

    // Constructors
    public Dormitories() {
    }

    // Getters and Setters
    public Long getDormitoryId() {
        return dormitoryId;
    }

    public void setDormitoryId(Long dormitoryId) {
        this.dormitoryId = dormitoryId;
    }

    public Long getUniversityId() {
        return universityId;
    }

    public void setUniversityId(Long universityId) {
        this.universityId = universityId;
    }

    public boolean isHasPrivateBathroom() {
        return hasPrivateBathroom;
    }

    public void setHasPrivateBathroom(boolean hasPrivateBathroom) {
        this.hasPrivateBathroom = hasPrivateBathroom;
    }

    public boolean isHasAirConditioning() {
        return hasAirConditioning;
    }

    public void setHasAirConditioning(boolean hasAirConditioning) {
        this.hasAirConditioning = hasAirConditioning;
    }

    public boolean isHasBunkBedDesk() {
        return hasBunkBedDesk;
    }

    public void setHasBunkBedDesk(boolean hasBunkBedDesk) {
        this.hasBunkBedDesk = hasBunkBedDesk;
    }

    public int getRoommateCount() {
        return roommateCount;
    }

    public void setRoommateCount(int roommateCount) {
        this.roommateCount = roommateCount;
    }}