package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RemoveSubFoldersFromFilesystem_1233 {
    public List<String> removeSubfolders(String[] folders) {
        if (folders.length == 0) {
            return Collections.emptyList();
        }
        Arrays.sort(folders);
        List<String> result = new ArrayList<>();
        String current = folders[0];
        result.add(current);
        current += "/";
        for (int i = 1; i < folders.length; i++) {
            if (!folders[i].startsWith(current)) {
                result.add(folders[i]);
                current = folders[i] + "/";
            }
        }
        return result;
    }
}
