package org.fostash.atomic.dsl;

import org.fostash.atomic.dsl.ansi.expressions.functions.LowerCase;
import org.fostash.atomic.dsl.ansi.expressions.functions.Trim;
import org.fostash.atomic.dsl.ansi.expressions.functions.UpperCase;

public interface IAlterable extends IExpression {

    default LowerCase toLowerCase() {
        return new LowerCase(this);
    }

    default UpperCase toUpperCase() {
        return new UpperCase(this);
    }

    default Trim trim() {
        return new Trim(this);
    }
}
