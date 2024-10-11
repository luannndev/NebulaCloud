package dev.luan.cloud.api;

import dev.luan.cloud.console.command.ICommandFactory;
import dev.luan.cloud.service.ICloudServiceFactory;
import dev.luan.cloud.service.group.ICloudServiceGroupFactory;
import dev.luan.cloud.template.ITemplateFactory;

public abstract class ICloudFactory {

    /*
     * Use this methode to get the ICloudServiceFactory
     * The ICloudServiceFactory is usefull to create or start services.
     */
    public abstract ICloudServiceFactory getServiceFactory();

    /*
     * Use this methode to get the ICloudServiceGroupFactory
     * The ICloudServiceFactory is usefull to create or delete service groups
     */
    public abstract ICloudServiceGroupFactory getServiceGroupFactory();

    /*
     * Use this methode to get the ITemplateFactory
     * The ITemplateFactory is usefull to create or delete templates
     */
    public abstract ITemplateFactory getTemplateFactory();

    /*
     * Use this methode to get the ICommandFactory
     * The ICommandFactory is usefull to register self-written commands.
     */
    public abstract ICommandFactory getCommandFactory();
}