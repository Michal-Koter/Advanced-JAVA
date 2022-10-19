package org.example.tools.geographies;

import org.example.model.Geography;
import org.example.tools.abstractions.IParse;


public class GeographyParser implements IParse <Geography> {

    @Override
    public Geography parse(String line){
        line = line.trim();
        String[] words = line.split(";");
        int id = Integer.parseInt(words[0]);
        String type = words[1];
        String name = words[2];
        String code = words[3];
        Integer parentId;
        if (words[4].equals("NULL")) {
            parentId = null;
        } else {
            parentId = Integer.parseInt(words[4]);
        }
        return new Geography(id,name,type,code,parentId);
    }

}
