package by.bsuir.lab1.resource;

import java.util.ResourceBundle;

public class ResourceManager {
    private static final ResourceManager instance = new ResourceManager();

    private ResourceBundle resourceBundle;
    private final String resourceName = "config";

    public static ResourceManager getInstance() { return instance;  }

    private ResourceManager() {
        resourceBundle = ResourceBundle.getBundle(resourceName);
    }

    public String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
