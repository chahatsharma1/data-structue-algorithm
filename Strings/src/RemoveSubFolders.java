import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveSubFolders {
    public List<String> removeSubfolders(String[] folder) {
        List<String> ans = new ArrayList<>();
        if(folder.length == 0){
            return ans;
        }

        Arrays.sort(folder);
        ans.add(folder[0]);

        for(int i = 1; i < folder.length; i++){
            String lastFolder = ans.getLast();
            String currentFolder = folder[i];

            if(!currentFolder.startsWith(lastFolder + "/")){
                ans.add(folder[i]);
            }
        }
        return ans;
    }
}
