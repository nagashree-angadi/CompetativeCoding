/*
* Comparing Strings containing Backspaces (medium) #
* Given two strings containing backspaces (identified by the character ‘#’),
* check if the two strings are equal.
* */
class BackspaceCompare {

    public static boolean compare(String str1, String str2) {
        int p1 = str1.length()-1;
        int p2 = str2.length()-1;

        while(p1>=0 && p2>=0){
            int count1 = 0, count2=0;
            while(str1.charAt(p1) == '#'){
                count1++;
                p1--;
            }
            while(str2.charAt(p2) == '#'){
                count2++;
                p2--;
            }
            while(count1>0){
                p1--;
                count1--;
            }
            while(count2>0){
                p2--;
                count2--;
            }
            if(p1>=0 && p2>=0 && str1.charAt(p1) != str2.charAt(p2))
                return false;

            p1--;
            p2--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(BackspaceCompare.compare("xy#z", "xzz#"));
        System.out.println(BackspaceCompare.compare("xy#z", "xyz#"));
        System.out.println(BackspaceCompare.compare("xp#", "xyz##"));
        System.out.println(BackspaceCompare.compare("xywrrmp", "xywrrmu#p"));
        System.out.println(BackspaceCompare.compare("x#ywr##r#mp#", "xyw#rr##mup##"));
    }
}
