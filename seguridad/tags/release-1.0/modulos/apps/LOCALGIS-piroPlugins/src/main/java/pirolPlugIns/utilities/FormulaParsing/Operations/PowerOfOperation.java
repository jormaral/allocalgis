/*
 * Created on 29.06.2005 for PIROL
 *
 * CVS header information:
 *  $RCSfile: PowerOfOperation.java,v $
 *  $Revision: 1.1 $
 *  $Date: 2009/07/03 12:31:47 $
 *  $Source: /usr/cvslocalgis/.CVSROOT/localgisdos/core/src/pirolPlugIns/utilities/FormulaParsing/Operations/PowerOfOperation.java,v $
 */
package pirolPlugIns.utilities.FormulaParsing.Operations;

import pirolPlugIns.utilities.FormulaParsing.FormulaValue;

import com.vividsolutions.jump.feature.Feature;

/**
 * Class to handle Math.pow() like operations. The result is a value that equals
 * <code>Math.pow(value1, value2)</code>.
 *
 * @author Ole Rahn
 * <br>
 * <br>FH Osnabr&uuml;ck - University of Applied Sciences Osnabr&uuml;ck,
 * <br>Project: PIROL (2005),
 * <br>Subproject: Daten- und Wissensmanagement
 * 
 * @version $Revision: 1.1 $
 * 
 */
public class PowerOfOperation extends GenericOperation {

    /**
     *@param value1
     *@param value2
     */
    public PowerOfOperation(FormulaValue value1, FormulaValue value2) {
        super(value1, value2);
    }

    /**
     *@param feature
     *@return Math.pow(value1, value2)
     */
    public double getValue(Feature feature) {
        return Math.pow(this.value1.getValue(feature), this.value2.getValue(feature));
    }
    
    
    /**
     *@inheritDoc
     */
    public String toString() {
        return "Math.pow("+ this.value1.toString() +", "+ this.value2.toString() +")";
    }
}
