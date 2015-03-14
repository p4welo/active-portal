module.exports = function (grunt) {
    'use strict';

    var version = generateAndSaveNewVersion('.version');

    grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),
        watch: {
            files: ['<%= jshint.files %>'],
            tasks: ['jshint']
        },
        jshint: {
            files: ['Gruntfile.js', 'src/main/webapp/app/**/*.js'],
            options: {
                globals: {
                    jQuery: true,
                    console: true,
                    module: true
                }
            }
        },
        clean: [
            "src/main/webapp/dist",
            "src/main/webapp/assets/dist"
        ],
        cssmin: {
            target: {
                options: {
                    keepSpecialComments: 0,
                    rebase: false
                },
                files: [
                    {
                        expand: true,
                        preserveLicenseComments: false,
                        cwd: 'src/main/webapp/assets/css',
                        src: ['*.css', '!*.min.css'],
                        dest: 'src/main/webapp/assets/css',
                        ext: '.min.css'
                    }
                ]
            }
        },
        replace: {
            dist: {
                options: {
                    patterns: [
                        {
                            json: {
                                "version": version
                            }
                        }
                    ]
                },
                files: [
                    {
                        expand: true,
                        flatten: true,
                        src: ['src/main/webapp/*.html'],
                        dest: 'src/main/webapp/'
                    }
                ]
            }
        },
        copy: {
            main: {
                src: 'src/main/webapp/assets/css/style.css',
                dest: 'src/main/webapp/assets/dist/style-' + version + ".css"
            }
        },
        htmlmin: {
            dist: {
                options: {
                    removeComments: true,
                    collapseWhitespace: true
                },
                files: [
                    {
                        expand: true,
                        cwd: 'src/main/webapp/pages',
                        src: '**/*.html',
                        dest: 'src/main/webapp/'
                    },
                    {
                        expand: true,
                        cwd: 'src/main/webapp/app',
                        src: '**/*.html',
                        dest: 'src/main/webapp/dist/app'
                    }
                ]
            }
        },
        requirejs: {
            compile: {
                options: {
                    mainConfigFile: "src/main/webapp/assets/js/start.js",
                    baseUrl: "src/main/webapp/app",
                    removeCombined: true,
                    findNestedDependencies: true,
                    preserveLicenseComments: false,

                    out: "src/main/webapp/dist/main-" + version + ".js",
                    name: "main"
                }
            }
        }
    });

    function generateAndSaveNewVersion(path) {
        var version = new Date().getTime();
        grunt.file.write(path, version);
        return version;
    }

    grunt.loadNpmTasks('grunt-contrib-uglify');
    grunt.loadNpmTasks('grunt-contrib-jshint');
    grunt.loadNpmTasks('grunt-contrib-watch');
    grunt.loadNpmTasks('grunt-contrib-cssmin');
    grunt.loadNpmTasks('grunt-contrib-htmlmin');
    grunt.loadNpmTasks('grunt-contrib-requirejs');
    grunt.loadNpmTasks('grunt-contrib-clean');
    grunt.loadNpmTasks('grunt-contrib-copy');
    grunt.loadNpmTasks('grunt-replace');

//    grunt.registerTask('default', ['jshint', 'clean', 'copy', 'requirejs', 'replace']);
    grunt.registerTask('default', ['jshint', 'clean', 'copy', 'htmlmin', 'requirejs', 'replace']);
};

