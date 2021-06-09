package de.fhws.gastrocom;

import junit.framework.TestCase;

import de.fhws.gastrocom.network.Action;
import de.fhws.gastrocom.network.ActionList;
import de.fhws.gastrocom.network.Type;

public class ListActivityTest extends TestCase {

    public void testActionsList() {
        ActionList actionList = new ActionList();
        actionList.addAction(new Action(1, Type.ORDER, 4, 3));
        actionList.addAction(new Action(2, Type.PAY, 5, 5));
        actionList.addAction(new Action(3, Type.ORDER, 3, 3));
        actionList.sort();

        assertEquals(2, actionList.get(0).getId());
        assertEquals(1, actionList.get(1).getId());
        assertEquals(3, actionList.get(2).getId());
    }

}