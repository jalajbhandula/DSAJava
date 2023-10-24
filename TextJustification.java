class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result=new ArrayList<String>();
        int i=0;
        while(i<=words.length-1){
            int j=i;
            int totalWords=0;
            int actualWidth=0;

            while(j<=words.length-1){
                if(actualWidth+((words[j].length())+totalWords)>maxWidth){
                    break;
                }else{
                    totalWords++;
                    actualWidth+=(words[j].length());
                }
                j++;
            }

            if(j>=words.length){
                StringBuilder s=new StringBuilder();
                for(int k=i;k<j-1;k++){
                    s.append(words[k]+" ");
                }

                if(totalWords==1){
                    int totalSpaces=maxWidth-words[j-1].length();
                    StringBuilder space=new StringBuilder();
                    while(totalSpaces-->0){
                    space.append(" ");
                }
                s.append(words[j-1]+space);
            }else{
                    s.append(words[j-1]);
                    int totalSpaces=maxWidth-s.toString().length();
                    StringBuilder space=new StringBuilder();
                    while(totalSpaces-->0){
                    space.append(" ");
                }
                s.append(space.toString());
            }
                result.add(s.toString());
                break;
            }

            int spaceWidth=maxWidth-actualWidth;
            int value=0;
            if(totalWords-1!=0){
                value=spaceWidth%(totalWords-1);
            }

            StringBuilder space=new StringBuilder();
            
            int totalSpaces=0;

            if(totalWords-1!=0){
                totalSpaces=spaceWidth/(totalWords-1);
            }
           
            while(totalSpaces-->0){
                space.append(" ");
            }

            StringBuilder s=new StringBuilder();
            for(int k=i;k<j-1;k++){
                StringBuilder overallSpace=new StringBuilder(space.toString());
                if(value!=0){
                    overallSpace.append(" ");
                    value--;
                }
                s.append(words[k]+overallSpace.toString());
            }

            if(totalWords==1){
                totalSpaces=maxWidth-words[i].length();

                while(totalSpaces-->0){
                space.append(" ");
                }
                s.append(words[j-1]+space.toString());
            }else{
                s.append(words[j-1]);
            }
            result.add(s.toString());
            i=j;
        }

        return result;
    }
}
