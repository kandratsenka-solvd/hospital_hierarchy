package tests;

import org.testng.annotations.Test;
import project.department.medical.MedicalDepartment;
import java.lang.reflect.*;


public class ReflectionTest {

    @Test
    public void testClassesWithReflection() throws InvocationTargetException, IllegalAccessException {
        Class<?> medicalDepartment = MedicalDepartment.class;
        Field[] fields = medicalDepartment.getDeclaredFields();
        Method[] methods = medicalDepartment.getDeclaredMethods();
        Constructor<?>[] constructors = medicalDepartment.getDeclaredConstructors();

        for (Field field : fields) {
            field.setAccessible(true);
            System.out.printf("""
                            "Field: %s"
                            "Type: %s"
                            "Modifiers: %s"
                            %n""",
                    field.getName(), field.getType().getName(), Modifier.toString(field.getModifiers()));
        }

        for (Constructor<?> constructor : constructors) {
            constructor.setAccessible(true);
            System.out.printf("""
                            "Constructor: %s"
                            "Modifiers: %s"
                            "Parameters: %s"
                            %n""",
                    constructor.getName(), Modifier.toString(constructor.getModifiers()),
                    Modifier.toString(constructor.getModifiers()));
            Parameter[] parameters = constructor.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println(parameter.getType().getName() + " " + parameter.getName() + "\n");
            }
        }

        for (Method method : methods) {
            method.setAccessible(true);
            int modifiers = method.getModifiers();
            System.out.printf("""
                            "Modifier: %s"
                            "Return type: %s"
                            "Method name: %s"
                            %n""",
                    Modifier.toString(modifiers), method.getReturnType().getName(), method.getName());
            Class<?>[] paramTypes = method.getParameterTypes();
            for (Class<?> paramType : paramTypes) {
                System.out.println(paramType.getName());
            }
            if (method.getName().equals("getDoctorsTotalNumber")) {
                method.setAccessible(true);
                method.invoke(null);
            }
        }
    }
}