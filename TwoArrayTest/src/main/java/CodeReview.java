import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Soren on 08/09/15.
 */
public class CodeReview {

    /*
    - Make better overview of the code by doing better line spaces between variables and functionality in the code
    - The parameter "boolean debug" is never used. Has to be removed.
    - Better naming of the ArrayList, not just one character
    - Use type parameters on list <E> telling the type of the parameter in the list
    - No use off exceptions - use try catch - what if the intilization of the allDevices list is empty or gets a null poiner exception
    - What if all this user/owner mismatch - how can "List owner" be cast to User? User i assume is a class object and owner must
      be extending User.
    - It has to be owners.get(y)

    This has to be inside the inner for loop and the checking for allDevices != null is not proper here... has to be done by try catch
    mentioned earlier
    if (found && allDevices != null)
        resultArrayList.add(allDevices.get(x));

    */

    /**
     * Code review
     * This shows how the code should be after being reviewed
     *
     * @param user
     * @return
     */
    public LinkedList getOfflineDevicesForUser(User user) {

        ArrayList resultArrayList = new ArrayList();

        try {
            List<?> allDevices = deviceRepository.getAll();

            for (int x=0; x<allDevices.size(); x++) {

                boolean found = false;
                List<?> owners = ((Device) allDevices.get(x)).getOwners();

                if (owners.size() > 0) {
                    for (int y=0; y<owners.size(); y++) {
                        User owner = (User) owners.get(y);
                        found = (owner == user);

                        if (found) {
                            resultArrayList.add(allDevices.get(x));
                            break;
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new LinkedList(resultArrayList);
    }
}