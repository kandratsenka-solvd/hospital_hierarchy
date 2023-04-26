package project.enums.specialTitle;

public enum NurseSpecialty {

    REGISTERED_NURSE("Registered Nurse"),
    LICENSED_PRACTICAL_NURSE("Licensed Practical Nurse"),
    CERTIFIED_NURSE_ASSISTANT("Certified Nurse Assistant"),
    NURSE_ANESTHETIST("Nurse Anesthetist"),
    NURSE_MIDWIFE("Nurse Midwife"),
    NURSE_PRACTITIONER("Nurse Practitioner");

    private final String nurseJobTitle;

    NurseSpecialty(String nurseJobTitle) {
        this.nurseJobTitle = nurseJobTitle;
    }

    public String getNurseJobTitle() {
        return nurseJobTitle;
    }
}