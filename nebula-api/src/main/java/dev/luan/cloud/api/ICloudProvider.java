package dev.luan.cloud.api;

import dev.luan.cloud.console.IConsoleProvider;
import dev.luan.cloud.entity.ICloudPlayerProvider;
import dev.luan.cloud.event.IEventProvider;
import dev.luan.cloud.module.IModuleProvider;
import dev.luan.cloud.node.INode;
import dev.luan.cloud.node.INodeProvider;
import dev.luan.cloud.pipe.IDefaultNebulaNetworking;
import dev.luan.cloud.service.ICloudService;
import dev.luan.cloud.service.ICloudServiceProvider;
import dev.luan.cloud.service.group.ICloudServiceGroupProvider;
import dev.luan.cloud.template.ITemplateProvider;

public abstract class ICloudProvider {

    /**
     * Use this methode to get the current server as ICloudService
     */
    public abstract ICloudService getThisService();

    /**
     * Use this methode to get the node where the service is running.
     */
    public abstract INode getThisNode();

    /**
     * Use this methode to get the ICloudServiceProvider
     * The ICloudServiceProvider is usefull to interact with CloudServices
     */
    public abstract ICloudServiceProvider getServiceProvider();

    /**
     * Use this methode to get the ICloudServiceProvider
     * The ICloudServiceProvider is usefull to interact with CloudServices
     */
    public abstract ICloudServiceGroupProvider getServiceGroupProvider();

    /**
     * Use this methode to get the ICloudPlayerProvider
     * The ICloudPlayerProvider is usefull to interact with cloud players
     */
    public abstract ICloudPlayerProvider getCloudPlayerProvider();

    /**
     * Use this methode to get the IConsoleProvider
     * The IConsoleProvider is usefull to interact with cloud console
     */
    public abstract IConsoleProvider getConsoleProvider();

    /**
     * Use this methode to get the IEventProvider
     * The IEventProvider is usefull to call events or add register a listener.
     */
    public abstract IEventProvider getEventProvider();

    /**
     * Use this methode to get the IModuleProvider
     * The IModuleProvider is usefull to get informations about a module.
     */
    public abstract IModuleProvider getModuleProvider();

    /**
     * Use this methode to get the INodeProvider
     * The INodeProvider is usefull to interact with nodes.
     */
    public abstract INodeProvider getNodeProvider();

    /**
     * Use this methode to get the ITemplateProvider
     * The ITemplateProvider is usefull to interact with templates
     */
    public abstract ITemplateProvider getTemplateProvider();

    /**
     * Use this methode to get the IDefaultNebulaNetworking
     */
    public abstract IDefaultNebulaNetworking getNebulaNetworking();

    /**
     * Use this methode to get the current version of the cloud
     */
    public abstract String getVersion();
}