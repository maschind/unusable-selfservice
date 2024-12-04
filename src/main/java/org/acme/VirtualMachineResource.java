package org.acme;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.core.MediaType;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

import java.util.Random;
import java.util.UUID;
import java.util.HashMap;
import java.util.Map;

@Path("/order")
public class VirtualMachineResource {

    @Inject
    Template orderForm;

    @Inject
    Template statusPage;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get() {
        return orderForm.instance();
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance submit(
        @FormParam("networkParam") String networkParam,
        @FormParam("storageParam") String storageParam,
        @FormParam("computeParam") String computeParam,
        @FormParam("osParam") String osParam) {

    // Generate a random boolean to decide whether to show an error
    boolean hasError = new Random().nextBoolean();

    // Create an instance of the data model
    StatusPageData data = new StatusPageData();
    data.hasError = hasError;

    if (!hasError) {
        data.ticketId = UUID.randomUUID().toString();

        // Generate fake stack trace message
        data.message = generateFakeStackTrace();

        // Generate additional random parameters
        data.randomParams = generateRandomParameters();

        // Set form parameters
        data.networkParam = networkParam;
        data.storageParam = storageParam;
        data.computeParam = computeParam;
        data.osParam = osParam;
    }

    return statusPage.data(data);
}

private String generateFakeStackTrace() {
    String[] exceptions = {
        "java.lang.NullPointerException",
        "java.lang.ArrayIndexOutOfBoundsException",
        "java.lang.IllegalArgumentException",
        "java.lang.ClassCastException",
        "java.lang.ArithmeticException",
        "java.lang.StackOverflowError",
        "java.lang.OutOfMemoryError",
        "java.io.IOException",
        "java.sql.SQLException",
        "java.net.SocketTimeoutException",
        "java.security.AccessControlException",
        "javax.naming.NamingException",
        "org.xml.sax.SAXException",
        "javax.xml.parsers.ParserConfigurationException",
        "org.hibernate.HibernateException",
        "org.springframework.beans.BeanInstantiationException",
        "org.apache.catalina.LifecycleException",
        "org.jboss.resteasy.spi.UnhandledException",
        "org.quartz.SchedulerException",
        "org.apache.kafka.common.KafkaException"
    };

    String[] classNames = {
        "com.example.service.UserService",
        "com.example.repository.OrderRepository",
        "com.example.controller.MainController",
        "com.example.util.HelperClass",
        "com.example.config.AppConfig",
        "com.example.model.User",
        "com.example.security.AuthManager",
        "com.example.Application",
        "com.example.Main",
        "com.example.Startup",
        "org.acme.VirtualMachineResource",
        "org.acme.SomeOtherClass",
        "org.acme.YetAnotherClass",
        "org.acme.handlers.ErrorHandler",
        "org.acme.utils.Utility",
        "org.acme.services.ServiceLayer",
        "org.acme.data.DataAccess",
        "org.acme.controllers.RestController",
        "org.acme.jobs.BackgroundJob",
        "org.acme.tasks.TaskRunner"
    };

    String[] methods = {
        "processData",
        "handleRequest",
        "initialize",
        "execute",
        "run",
        "call",
        "compute",
        "loadData",
        "saveData",
        "connect",
        "disconnect",
        "validate",
        "authenticate",
        "authorize",
        "start",
        "stop",
        "restart",
        "main",
        "setup",
        "cleanup"
    };

    Random rand = new Random();
    StringBuilder sb = new StringBuilder();

    // Select a random exception
    String exception = exceptions[rand.nextInt(exceptions.length)];
    sb.append(exception).append(": ").append("Simulated error message").append("\n");

    // Generate a random number of stack trace elements
    int stackDepth = rand.nextInt(10) + 5; // between 5 and 14

    for (int i = 0; i < stackDepth; i++) {
        String className = classNames[rand.nextInt(classNames.length)];
        String methodName = methods[rand.nextInt(methods.length)];
        int lineNumber = rand.nextInt(100) + 1;
        sb.append("\tat ").append(className)
            .append(".").append(methodName)
            .append("(").append(className.substring(className.lastIndexOf(".") + 1))
            .append(".java:").append(lineNumber).append(")").append("\n");
    }

    return sb.toString();
}


    private String generateRandomMessage() {
        // Populate the words array with ITIL and tech jargon
        String[] words = {
            "ITIL", "SLA", "KPI", "throughput", "latency", "synergy", "leverage", "paradigm",
            "holistic", "bandwidth", "mission-critical", "framework", "scalable", "enterprise",
            "cloud", "blockchain", "AI", "machine learning", "DevOps", "containerization",
            "microservices", "orchestration", "agile", "scrum", "sprint", "backlog",
            "continuous integration", "continuous deployment", "blue-green deployment",
            "infrastructure", "as code", "virtualization", "hypervisor", "multi-tenancy",
            "policy", "compliance", "governance", "audit", "change management", "incident",
            "problem", "root cause analysis", "service catalog", "ticketing", "escalation",
            "approval", "workflow", "process", "procedure", "guideline", "best practice",
            "assessment", "maturity", "capability", "optimization", "efficiency", "effectiveness",
            "benchmarking", "alignment", "strategy", "roadmap", "vision", "mission", "values",
            "stakeholder", "engagement", "communication", "reporting", "dashboard", "metric",
            "performance", "objective", "goal", "tactic", "initiative", "risk", "issue",
            "dependency", "constraint", "assumption", "deliverable", "milestone", "phase",
            "iteration", "increment", "release", "deployment", "transition", "operation",
            "support", "maintenance", "end-of-life", "decommission", "retirement",
            "service level agreement", "operating level agreement", "underpinning contract",
            "business continuity", "disaster recovery", "capacity planning", "availability",
            "reliability", "maintainability", "serviceability", "scalability", "usability",
            "interoperability", "portability", "confidentiality", "integrity", "authentication",
            "authorization", "non-repudiation", "auditability", "transparency", "accountability",
            "traceability", "governance", "policy", "standard", "regulation", "law", "ethics",
            "sustainability", "innovation"
        };
    
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();
        int wordCount = 0;
        while (wordCount < 2000) {
            int sentenceLength = rand.nextInt(15) + 5; // Sentences of 5 to 19 words
            for (int i = 0; i < sentenceLength; i++) {
                String word = words[rand.nextInt(words.length)];
                sb.append(word).append(" ");
                wordCount++;
            }
            sb.append(". ");
        }
    
        return sb.toString();
    }
    

    private Map<String, String> generateRandomParameters() {
        String[] paramNames = {
            "Quantum Entanglement Level",
            "Flux Capacitor Charge",
            "Neural Net Depth",
            "Holographic Cache Size",
            "Photon Emission Rate",
            "Dark Matter Density",
            "Wormhole Stability Index",
            "Antimatter Containment Unit",
            "Time Dilation Factor",
            "Graviton Polarity",
            "Entropy Coefficient",
            "Superstring Tension",
            "Fractal Compression Ratio",
            "Zero Point Energy",
            "Singularity Threshold",
            "Chromatic Aberration Index",
            "Anomalous Data Flux",
            "Event Horizon Proximity",
            "Pulsar Synchronization",
            "Quasar Intensity"
        };
    
        Map<String, String> params = new HashMap<>();
        Random rand = new Random();
    
        int numParams = rand.nextInt(5) + 3; // Generate between 3 to 7 parameters
    
        for (int i = 0; i < numParams; i++) {
            String paramName = paramNames[rand.nextInt(paramNames.length)];
            String paramValue = "Value " + rand.nextInt(10000);
            params.put(paramName, paramValue);
        }
    
        return params;
    }
    
}
