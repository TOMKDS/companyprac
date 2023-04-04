package foodorder.infra;

import foodorder.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class StoreHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Store>> {

    @Override
    public EntityModel<Store> process(EntityModel<Store> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/acceptreject")
                .withRel("acceptreject")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/cookstart")
                .withRel("cookstart")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/cookfinish")
                .withRel("cookfinish")
        );

        return model;
    }
}
