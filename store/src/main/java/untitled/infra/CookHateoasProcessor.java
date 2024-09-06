package untitled.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import untitled.domain.*;

@Component
public class CookHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Cook>> {

    @Override
    public EntityModel<Cook> process(EntityModel<Cook> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "//isaccept")
                .withRel("/isaccept")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "//startcook")
                .withRel("/startcook")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "//completecook")
                .withRel("/completecook")
        );

        return model;
    }
}
