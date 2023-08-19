class Solution {
    public static void swap(String[] files, int idx1, int idx2){
        String tmp = files[idx1];
        files[idx1] = files[idx2];
        files[idx2] = tmp;
    }
    public static boolean digit(Character ch){
        return Character.isDigit(ch);
    }
    public static char alphabet(Character ch){
        return Character.toLowerCase(ch);
    }
    
    public String[] solution(String[] files) {
        for(int i = 0; i < files.length - 1; i++){
            for(int j = 0; j < files.length - 1; j++){
                int idx = 0;

                while(true) {
                    char ch1 = files[j].charAt(idx);
                    char ch2 = files[j + 1].charAt(idx);

                    if(digit(ch1) && !digit(ch2)) break;
                    else if(!digit(ch1) && digit(ch2)){
                        swap(files, j, j + 1);
                        break;
                    }
                    else if(digit(ch1) && digit(ch2)){
                        int sum = 0;

                        for(int k = idx; k < files[j].length(); k++){
                            if(!digit(files[j].charAt(k))){
                                sum += Integer.valueOf(files[j].substring(idx, k));
                                break;
                            }
                            else if(digit(files[j].charAt(k)) && k == files[j].length() - 1){
                                sum += Integer.valueOf(files[j].substring(idx, k + 1));
                                break;
                            }
                        }

                        for(int k = idx; k < files[j + 1].length(); k++){
                            if(!digit(files[j + 1].charAt(k))){
                                sum -= Integer.valueOf(files[j + 1].substring(idx, k));
                                break;
                            }
                            else if(digit(files[j + 1].charAt(k)) && k == files[j + 1].length() - 1){
                                sum -= Integer.valueOf(files[j + 1].substring(idx, k + 1));
                                break;
                            }
                        }

                        if(sum > 0) swap(files, j, j + 1);
                        break;
                    }
                    else if(alphabet(ch1) > alphabet(ch2)){
                        swap(files, j, j + 1);
                        break;
                    }
                    else if(alphabet(ch1) < alphabet(ch2)) break;

                    idx++;
                }
            }
        }
        
        return files;
    }
}