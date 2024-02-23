class Solution {
    public int solution(String s) {
        int answer = s.length();
        int length = 1;

        while(length <= s.length() / 2){
            StringBuilder zip = new StringBuilder();
            int backup = 0;

            for(int i = 0; i < s.length();){
                int count = 1;

                for(int j = i + length; j < s.length(); j += length){
                    if(j + length - 1 < s.length() && s.substring(i, i + length).equals(s.substring(j, j + length))){
                        count++;
                        if(j + length == s.length()) backup = s.length();
                    }
                    else {
                        backup = j;
                        break;
                    }
                }

                if(count >= 2) zip.append(count);

                zip.append(s.substring(i, i + length));

                if(s.length() - backup < 2 * length){
                    zip.append(s.substring(backup, s.length()));
                    break;
                }

                i = backup;
            }

            int zip_length = zip.toString().length();

            if(zip_length < answer) answer = zip_length;

            length++;
        }
        
        return answer;
    }
}