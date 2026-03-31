class Solution {

    public String encode(List<String> strs) {
       StringBuilder enc = new StringBuilder();
       for(String str : strs){
           enc.append(str).append("§");
       }
       return enc.toString();
    }

    public List<String> decode(String str) {
       StringBuilder dec = new StringBuilder();
       List<String> res = new ArrayList<>();
       for(char c : str.toCharArray()){
        if(c == '§'){
            res.add(dec.toString());
        dec.setLength(0);
            continue;
        }
        dec.append(c);
       }
       return res;
    }
}
