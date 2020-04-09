public class IDNum {
    String IDNum;

    public static boolean checkIDNum(String IDNum){
        if(IDNum.length()!=18)
            return false;
        char[] num=IDNum.toCharArray();
        int ans=0;
        int year=(num[6]-'0')*1000+(num[7]-'0')*100+(num[8]-'0')*10+(num[9]-'0');
        int month=(num[10]-'0')*10+(num[11]-'0');
        int day=(num[12]-'0')*10+(num[13]-'0');
        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:{
                if(day<=0||day>31)
                    return false;
                break;
            }
            case 4:
            case 6:
            case 9:
            case 11:{
                if(day<=0||day>30)
                    return false;
                break;
            }
            case 2:{
                if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
                    if(day<=0||day>29){
                        return false;
                    }
                }
                else{
                    if(day<=0||day>28){
                        return false;
                    }
                }
                break;
            }
            default:
                return false;
        }
        for (int i = 0; i < 18; i++) {
            if(i==17){
                if(num[i]=='x'||num[i]=='X') {
                    ans+=10;
                    break;
                }
            }
            if(num[i]>='0'&&num[i]<='9') {
                ans += (num[i] - '0') * (Math.pow(2, (17 - i)) % 11);
            }
            else
                return false;
        }
        if(ans%11==1)return true;
        return false;
    }

    public String toString(){
        char[] tmp=IDNum.toCharArray();
        if(tmp[17]=='x')tmp[17]='X';
        return String.valueOf(tmp);
    }

    public char konwSex(){
        int sex=IDNum.charAt(16)-'0';
        if(sex%2==1)return 'M';
        return 'F';
    }

    public String knowbirthday(){
        String birthday=IDNum.substring(6,10)+"/"+IDNum.substring(10,12)+"/"+IDNum.substring(12,14);
        return birthday;
    }
    public static int pow(int k){
        if(k==0)return 1;
        int ans=1;
        for (int i = 0; i < k; i++) {
            ans=(ans*2)%11;
        }
        return ans;
    }
}