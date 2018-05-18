package application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Controller
@PropertySource("classpath:properties/connection.properties")
public class ImageController {

    @Autowired
    Environment environment;

    @RequestMapping(value = "/content/profile/{path}")
    @ResponseBody
    public byte[] getFranchiseImages(@PathVariable(value = "path") String path) throws IOException {
        File baseFolder = new File(environment.getProperty("base.location"));

        File profileImg = new File(baseFolder.getPath()+"/"+environment.getProperty("profile.location")+path+".jpg");
        // If the image doesn't exists, then we have to use a default image as replacement.
        if(!profileImg.exists()) {
            File noImage = new File(environment.getProperty("base.location")+"no_image.png");
            return Files.readAllBytes(noImage.toPath());

        }
        return Files.readAllBytes(profileImg.toPath());
    }

}
