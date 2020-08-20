package rock.java;

import de.odysseus.el.ExpressionFactoryImpl;
import de.odysseus.el.util.SimpleContext;

import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import java.math.BigDecimal;
import java.util.Date;

public class SubStringTest {

    public static void main(String[] args) throws NoSuchMethodException {
        // the User implementation is de.odysseus.el.User
        User user = new User();
        user.setAge(11);
        user.setBirthday(new Date());
        user.setName("lizhihua03");
        user.setSalary(new BigDecimal(100.1));
        user.setSex(true);
        // package de.odysseus.el.util provides a ready-to-use subclass of ELContext
        SimpleContext context = new SimpleContext();
        ExpressionFactory factory = new ExpressionFactoryImpl();
        String s = "${age>20}";
        ValueExpression valueExpression = factory.createValueExpression(context, s, String.class);
        System.out.println(valueExpression.getValue(context));

    }

}
