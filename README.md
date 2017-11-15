# springtraining
Using a handler mapping you can map incoming web requests to appropriate handlers

The functionality a basic HandlerMapping provides is the delivering of a HandlerExecutionChain, which must contain the handler that matches the incoming request, and may also contain a list of handler interceptors that are applied to the request


When a request comes in, the DispatcherServlet will hand it over to the handler mapping to let it inspect the request and come up with an appropriate HandlerExecutionChain. Then the DispatcherServlet will execute the handler and interceptors in the chain (if any).

	1. Handler Mappings
	With no explicit handler mapper registered, a default BeanNameHandlerMapping will be used, If we explicitly register a different handler mapper, the default mapper will be overridden:
	
		a. SimpleUrlHandlerMapping 
		b. BeanNameUrlHandlerMapping
		c. ControllerClassNameHandlerMapping

	2. Configuring Priorities

	<bean class="org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping">
	    <property name="order" value="2" />
	</bean>

	3. Common properties
		a. interceptors
		b. defaultHandler
		Make sure you put more specific request handler before less specific one
		@RequestMapping(value = "/**")
		public String doDefault(ModelMap modelMap) {
		   ...
		}
		c. order
		d. alwaysUseFullPath
		e. urlDecode
		f. lazyInitHandlers
