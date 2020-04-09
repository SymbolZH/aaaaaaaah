public class PersonTest {
    public static void main(String[] args) {
        if(args[0].compareTo("cid")==0){
            System.out.println(IDNum.checkIDNum(args[1]));
        }
        else if(args[0].compareTo("np")==0){
            Person person=Person.newPerson(args[1],args[2]);
            if(person==null)
                System.out.println("ID illegal");
            else{
                System.out.println(person.toString());
            }
        }
    }
}
