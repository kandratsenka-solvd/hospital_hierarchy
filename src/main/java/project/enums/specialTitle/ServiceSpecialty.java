package project.enums.specialTitle;

public enum ServiceSpecialty {

    JANITOR("janitor"),
    SECURITY_GUARD("security guard"),
    RECEPTIONIST("receptionist");

    private final String serviceJobTitle;

    ServiceSpecialty(String serviceJobTitle) {
        this.serviceJobTitle = serviceJobTitle;
    }

    public String getServiceJobTitle() {
        return serviceJobTitle;
    }
}