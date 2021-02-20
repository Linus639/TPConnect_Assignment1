/**
 * The runner package contains the logic of bootstrapping TestNG and executing the service tests.
 *
 * <p> The {@link TPConnect_RestAssueredWithBDD.TPConnect_RestAssueredWithBDD.runner.TestRunner} contains the main method that will be executed once the project is
 * packaged into a Jar.
 *
 * <p> The {@link TPConnect_RestAssueredWithBDD.TPConnect_RestAssueredWithBDD.runner.CommandLineParams} defines and validates the parameters supplied to the project. It
 * will also house the "common" defaults in the event the project is started without executing the
 * {@link TPConnect_RestAssueredWithBDD.TPConnect_RestAssueredWithBDD.runner.TestRunner#main(String[]) TestRunner.main(String[] args)}. Note: This is usually
 * during development of the tests when the developer wants to execute through the IDE.
 *
 * <p> The {@link TPConnect_RestAssueredWithBDD.TPConnect_RestAssueredWithBDD.runner.TestReporter} manages logging from the application. This is useful as it will
 * provide clean output on the build server.
 *
 * @author <a href="mailto:JGraham@aimconsulting.com">Justin Graham</a>
 * @since 2/15/16
 */
package TPConnect_RestAssueredWithBDD.TPConnect_RestAssueredWithBDD.runner;