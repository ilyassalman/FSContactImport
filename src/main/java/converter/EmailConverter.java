package converter;

import domain.EmailsEntity;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Lukas on 27.04.2015.
 */
public class EmailConverter extends AbstractConverter<Collection<EmailsEntity>> {
    Collection<EmailsEntity> emailsEntities;

    public EmailConverter() {
        this.emailsEntities = new ArrayList<>();
    }

    @Override
    public AbstractConverter<Collection<EmailsEntity>> addValue(String value) {
        if(emailsEntities.size() >= 2){
            emailsEntities.clear();
        }
        EmailsEntity emailsEntity = new EmailsEntity();
        emailsEntity.setValue(value);
        emailsEntity.setImportant(emailsEntities.isEmpty());
        return this;
    }

    @Override
    public Collection<EmailsEntity> build() {
        return emailsEntities;
    }
}
