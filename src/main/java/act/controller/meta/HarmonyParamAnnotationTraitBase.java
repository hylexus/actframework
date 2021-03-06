package act.controller.meta;

import org.osgl.$;
import org.osgl.util.S;

/**
 * A {@code HarmonyParamAnnotationTraitBase} is compatible with other {@link ParamAnnoInfoTrait}
 * except a annotation with the same type of itself
 */
public abstract class HarmonyParamAnnotationTraitBase extends ParamAnnoInfoTraitBase {
    protected HarmonyParamAnnotationTraitBase(int index) {
        super(index);
    }

    @Override
    public boolean compatibleWith(ParamAnnoInfoTrait otherParamAnnotation) {
        return $.eq(otherParamAnnotation.getClass(), this.getClass());
    }

    @Override
    public String compatibilityErrorMessage(ParamAnnoInfoTrait otherParamAnnotation) {
        if ($.eq(otherParamAnnotation.getClass(), getClass())) {
            return S.fmt("Duplicated annotation found: %s", getClass());
        }
        return null;
    }
}
