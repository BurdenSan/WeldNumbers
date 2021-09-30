/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RobotWeldSearch;
import java.util.List;

import ca.odell.glazedlists.TextFilterator;
/**
 *
 * @author aburd
 */
public class CellNameFilterator implements TextFilterator <String> {

    @Override
    public void getFilterStrings(List<String> baseList, String element) {
         //To change body of generated methods, choose Tools | Templates.
        baseList.add(element);
    }
    
}
