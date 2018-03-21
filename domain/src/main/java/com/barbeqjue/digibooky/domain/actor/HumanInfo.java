package com.barbeqjue.digibooky.domain.actor;

public class HumanInfo {
    private String firstName;
    private String lastName;
    private String email;

    private HumanInfo(){}

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public static class HumanInfoBuilder{
        private Integer id;
        private String firstName;
        private String lastName;
        private String email;

        private HumanInfoBuilder(){}

        public static HumanInfoBuilder humanInfo(){
            return new HumanInfoBuilder();
        }

        public HumanInfo build(){
            HumanInfo humanInfo = new HumanInfo();
            humanInfo.setFirstName(firstName);
            humanInfo.setLastName(lastName);
            humanInfo.setEmail(email);
            return humanInfo;
        }

        public HumanInfoBuilder withId(Integer id){
            this.id = id;
            return this;
        }

        public HumanInfoBuilder withFirstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public HumanInfoBuilder withLastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public HumanInfoBuilder withEmail(String email){
            this.email = email;
            return this;
        }
    }
}
