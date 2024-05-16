package iki;

public class StrCpy {
    void copyStr(String str1, StringBuilder str2, int index) {
        char[] charArray = str1.toCharArray();

        if (str2 == null) {
            str2 = new StringBuilder();
        }

        if (index >= charArray.length) {
            return;
        }

        str2.append(charArray[index]);

        copyStr(str1, str2, index + 1);
    }

    public static void main(String[] args) {
        StrCpy st = new StrCpy();
        StringBuilder result = new StringBuilder();
        st.copyStr("merhaba", result, 0);
        System.out.println(result.toString());
    }
}
