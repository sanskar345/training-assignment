import org.moqui.context.ExecutionContext
import org.moqui.entity.EntityQueryBuilder
import org.moqui.entity.EntityCondition

class FemalePersons {
    def getFemalePersons(ExecutionContext ec) {
        def personsList = [];

        def query = new EntityQueryBuilder('Person').where(EntityCondition.makeCondition('gender', EntityCondition.EQUALS, 'F'));
        def result = ec.getEntityList(query);

        if (result.success) {
            personsList = result.entityList;
        } else {
            println("Error retrieving female persons: ${result.error}");
        }

        // Set the out parameter value
        ec.parameters.personsList = personsList;
    }
}
