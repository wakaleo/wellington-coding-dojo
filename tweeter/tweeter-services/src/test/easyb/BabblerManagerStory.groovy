import com.sonatype.training.babble.services.NameAlreadyExistsException
import com.sonatype.training.babble.services.BabbleManager

/**
 * A simple scenario
 */
scenario "a babbler should have a unique name", {
    given "a new babbler called 'Joe'", {
        manager = BabbleManager.getInstance();
        manager.clear();    	
    	manager.register("joe")
    } 
    when "someone tries to create another user babbler called 'joe'", {
       createNewAccountWithExistingName = {
    	    	manager.register("joe")
       }    	
    }
    then "a NameAlreadyExistsException should be thrown", {
    	ensureThrows(NameAlreadyExistsException){
    		createNewAccountWithExistingName()
        }
    }
    and "there is only one babbler called 'joe", {
    	manager.findByName("joe").name.shouldBe "joe"
    }
}