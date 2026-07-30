class Solution {

    public String encode(List<String> strs) {

    StringBuilder sb = new StringBuilder();

    for (String str : strs) {

        sb.append(str.length());
        sb.append("#");
        sb.append(str);

    }

    return sb.toString();
}

    public List<String> decode(String s) {

    List<String> result = new ArrayList<>();

    int i = 0;

    while (i < s.length()) {

        int j = i;

        while (s.charAt(j) != '#') {
            j++;
        }

        int length = Integer.parseInt(s.substring(i, j));

        int start = j + 1;

        String str = s.substring(start, start + length);

        result.add(str);

        i = start + length;
    }

    return result;
}
}
