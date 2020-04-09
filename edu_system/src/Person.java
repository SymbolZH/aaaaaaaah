public class Person {
    private IDNum idNum;
    private String name;
    private char sex;
    private String birthday;

    public Person() {
    }

    public String toString(){
        String string="Name:"+name+"\n"+"IDNum:"+idNum.toString()+"\n"+"Sex:"+sex+"\n"+"Birthday:"+birthday;
        return string;
    }

    public static Person newPerson(String input){
        String id=input.substring(input.length()-18,input.length());
        String name=input.substring(0,input.length()-18);
        if(IDNum.checkIDNum(id)==false)
            return null;
        IDNum idnum=new IDNum();
        idnum.IDNum=id;
        idnum.IDNum=idnum.toString();
        Person person=new Person();
        person.setIdNum(idnum);
        person.setName(name);
        person.setSex(idnum.konwSex());
        person.setBirthday(idnum.knowbirthday());
        return person;
    }
    public static Person newPerson(String name,String id){
        if(IDNum.checkIDNum(id)==false)
            return null;
        IDNum idnum=new IDNum();
        idnum.IDNum=id;
        idnum.IDNum=idnum.toString();
        Person person=new Person();
        person.setIdNum(idnum);
        person.setName(name);
        person.setSex(idnum.konwSex());
        person.setBirthday(idnum.knowbirthday());
        return person;
    }

    public IDNum getIdNum() {
        return idNum;
    }

    public void setIdNum(IDNum idNum) {
        this.idNum = idNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public char konwSex(String idnum){
        int sex=idnum.charAt(16)-'0';
        if(sex%2==1)return 'M';
        return 'F';
    }
    public String knowbirthday(String idnum){
        String birthday=idnum.substring(6,10)+"/"+idnum.substring(10,12)+"/"+idnum.substring(12,14);
        return birthday;
    }
}
