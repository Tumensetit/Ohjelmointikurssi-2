public class maini {

    public static void main(String[] args){

        Student student1 = new Student();
        Student student2 = new Student("Mouse", "Mickey");
        student1.setFirstName("Donald");
        student1.setLastName("Duck");
        student1.setId(0);
        student1.setBachelorCredits(180);
        student1.setMasterCredits(120);
        student1.setTitleOfBachelorThesis("Bachelor thesis title");
        student1.setStartYear(2021);
        student1.setGraduationYear(2021);

        student2.setFirstName(null);
        student2.setLastName(null);
        student2.setBachelorCredits(180);
        student2.setMasterCredits(120);
        student2.setTitleOfBachelorThesis("How to survive a bachelors thesis");
        student2.setTitleOfMastersThesis("Happy ending");
        student2.setId(101);

        System.out.println(student1.toString());
        System.out.println(student2.toString());
        System.out.println(student1.setGraduationYear(2023));
        System.out.println(student2.setGraduationYear(2019));

    }
    
}