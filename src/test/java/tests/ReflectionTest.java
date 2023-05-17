package tests;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import project.department.medical.MedicalDepartment;
import utils.LoggerUtil;

import java.lang.reflect.*;


public class ReflectionTest {

    @Test
    public void testClassesWithReflection() throws InvocationTargetException, IllegalAccessException {
        final Logger LOGGER = LoggerUtil.getLogger();
        Class<?> medicalDepartment = MedicalDepartment.class;
        Field[] fields = medicalDepartment.getDeclaredFields();
        Method[] methods = medicalDepartment.getDeclaredMethods();
        Constructor<?>[] constructors = medicalDepartment.getDeclaredConstructors();

        for (Field field : fields) {
            field.setAccessible(true);
            LOGGER.info("""
                Field: {}
                Type: {}
                Modifiers: {}
                """, field.getName(), field.getType().getName(), Modifier.toString(field.getModifiers()));
        }

        for (Constructor<?> constructor : constructors) {
            constructor.setAccessible(true);
            LOGGER.info("""
                            Constructor: {}
                            Modifiers: {}
                            Parameters: {}
                            """,
                    constructor.getName(), Modifier.toString(constructor.getModifiers()),
                    Modifier.toString(constructor.getModifiers()));
            Parameter[] parameters = constructor.getParameters();
            for (Parameter parameter : parameters) {
                LOGGER.info(parameter.getType().getName() + " " + parameter.getName() + "\n");
            }
        }

        for (Method method : methods) {
            method.setAccessible(true);
            int modifiers = method.getModifiers();
            LOGGER.info("""
                            Modifier: {}
                            Return type: {}
                            Method name: {}
                            """,
                    Modifier.toString(modifiers), method.getReturnType().getName(), method.getName());
            Class<?>[] paramTypes = method.getParameterTypes();
            for (Class<?> paramType : paramTypes) {
                LOGGER.info(paramType.getName());
            }
            if (method.getName().equals("getDoctorsTotalNumber")) {
                method.setAccessible(true);
                method.invoke(null);
            }
        }
    }
}