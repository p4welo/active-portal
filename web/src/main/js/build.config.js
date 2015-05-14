/**
 * This file/module contains all configuration for the build process.
 */
module.exports = {
    /**
     * The `build_dir` folder is where our projects are compiled during
     * development and the `compile_dir` folder is where our app resides once it's
     * completely built.
     */
    build_dir: '../webapp',
    compile_dir: '../webapp',

    /**
     * This is a collection of file patterns that refer to our app code (the
     * stuff in `src/`). These file paths are used in the configuration of
     * build tasks. `js` is all project javascript, less tests. `ctpl` contains
     * our reusable components' (`src/common`) template HTML files, while
     * `atpl` contains the same, but for our app's code. `html` is just our
     * main HTML file, `less` is our main stylesheet, and `unit` contains our
     * app's unit tests.
     */
    app_files: {
        js: ['src/**/*.js', '!src/**/*.spec.js', '!src/assets/**/*.js'],
        jsunit: ['src/**/*.spec.js'],

        atpl: ['src/app/**/*.tpl.html'],
        ctpl: ['src/common/**/*.tpl.html'],

        html: [
            'src/index.html'
        ],
        login_html: [
            '<%= build_dir %>/login.html'
        ],
        index_html: [
            '<%= build_dir %>/index.html'
        ],
        less: 'src/less/main.less'
    },

    /**
     * This is a collection of files used during testing only.
     */
    test_files: {
        js: [
            'vendor/angular-mocks/angular-mocks.js'
        ]
    },

    /**
     * This is the same as `app_files`, except it contains patterns that
     * reference vendor code (`vendor/`) that we need to place into the build
     * process somewhere. While the `app_files` property ensures all
     * standardized files are collected for compilation, it is the user's job
     * to ensure non-standardized (i.e. vendor-related) files are handled
     * appropriately in `vendor_files.js`.
     *
     * The `vendor_files.js` property holds files to be automatically
     * concatenated and minified with our project source files.
     *
     * The `vendor_files.css` property holds any CSS files to be automatically
     * included in our app.
     *
     * The `vendor_files.assets` property holds any assets to be copied along
     * with our app's assets. This structure is flattened, so it is not
     * recommended that you use wildcards.
     */
    vendor_files: {
        js: [
            'vendor/proui/js/vendor/jquery-1.11.2.min.js',

            'vendor/angular/angular.js',
            'vendor/angular-locale/angular-locale_pl-pl.js',
            'vendor/angular-sanitize/angular-sanitize.js',
            'vendor/angular-resource/angular-resource.js',
            'vendor/angular-animate/angular-animate.js',
            'vendor/angular-touch/angular-touch.js',
            'vendor/angular-translate/angular-translate.js',
            'vendor/angular-bootstrap/ui-bootstrap-tpls.min.js',
            'vendor/angular-ui-router/release/angular-ui-router.js',
            'vendor/angular-loading-bar/build/loading-bar.min.js',
            'vendor/angular-ui-utils/modules/route/route.js',

            'vendor/moment/min/moment.min.js',
            'vendor/fullcalendar/dist/fullcalendar.js',
            'vendor/angular-ui-calendar/src/calendar.js',
            'vendor/lodash/lodash.min.js',
            'vendor/pnotify/pnotify.core.js',

            'vendor/proui/js/vendor/modernizr-respond.min.js',
            'vendor/proui/js/vendor/bootstrap.min.js',
            'vendor/proui/js/plugins.js',
            'vendor/proui/js/app.js'
        ],
        css: [
            'vendor/proui/css/bootstrap.min.css',
            'vendor/proui/css/plugins.css',
            'vendor/proui/css/main.css',
            'vendor/proui/css/themes.css',
            'vendor/proui/css/themes/fancy.css',
            'vendor/pnotify/pnotify.core.css',
            'vendor/angular-loading-bar/build/loading-bar.min.css',
            'vendor/animate.css/animate.min.css'
        ],
        assets: [
            'vendor/proui/img/*.png'
        ],
        fonts: [
            'vendor/proui/css/fonts/'
        ]
    }
};
