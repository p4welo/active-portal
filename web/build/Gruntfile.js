module.exports = function (grunt) {
    'use strict';

    var version = generateAndSaveNewVersion('.version');
    var dateTime = generateCurrentDate();

    grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),
        watch: {
            files: ['<%= jshint.files %>'],
            tasks: ['jshint']
        },
        "bower-install-simple": {
            options: {
                color: true
            },
            "prod": {
                options: {
                    production: true
                }
            }
        },
        jshint: {
            files: ['Gruntfile.js', '../src/main/webapp/app/**/*.js'],
            options: {
                globals: {
                    jQuery: true,
                    console: true,
                    module: true
                }
            }
        },
        clean: {
            files: ["../src/main/webapp/dist"],
            options: {
                force: true
            }
        },
        cssmin: {
            target: {
                options: {
                    keepSpecialComments: 0,
                    preserveLicenseComments: false,
                    rebase: false
                },
                files: [
                    {
                        src: '../src/main/webapp/dist/assets/css/style.css',
                        dest: '../src/main/webapp/dist/assets/css/style.css'
                    }
                ]
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
                        cwd: '../src/main/webapp',
                        src: '*.html',
                        dest: '../src/main/webapp/dist'
                    },
                    {
                        expand: true,
                        cwd: '../src/main/webapp/app',
                        src: '**/*.html',
                        dest: '../src/main/webapp/dist/app'
                    }
                ]
            }
        },
        uglify: {
            start: {
                files: [
                    {
                        src: '../src/main/webapp/assets/start.js',
                        dest: '../src/main/webapp/dist/assets/start.js'
                        //dest: '../src/main/webapp/dist/assets/start-' + version +'.js'
                    }
                ]
            }
        },
        copy: {
            main: {
                files: [
                    {
                        expand: true,
                        cwd: '../src/main/webapp/assets/',
                        src: '**/*.*',
                        dest: '../src/main/webapp/dist/assets/'
                    },
                    {
                        src: '../src/main/webapp/WEB-INF/web.xml',
                        dest: '../src/main/webapp/dist/WEB-INF/web.xml'
                    }
                ]
            }
        },
        requirejs: {
            compile: {
                options: {
                    mainConfigFile: "../src/main/webapp/assets/start.js",
                    baseUrl: "../src/main/webapp/app",
                    removeCombined: true,
                    findNestedDependencies: true,
                    preserveLicenseComments: false,

                    out: "../src/main/webapp/dist/assets/start1.js",
                    name: "main"
                }
            }
        },
        replace: {
            dist: {
                options: {
                    patterns: [
                        {
                            json: {
                                "version": version,
                                "dateTime": dateTime
                            }
                        }
                    ]
                },
                files: [
                    {
                        expand: true,
                        flatten: true,
                        src: ['../src/main/webapp/dist/*.html'],
                        dest: '../src/main/webapp/dist/'
                    }
                ]
            }
        },
        rename: {
            main: {
                files: [
                    {
                        src: ['../src/main/webapp/dist/assets/start.js'],
                        dest: '../src/main/webapp/dist/assets/start_old.js'
                    },
                    {
                        src: ['../src/main/webapp/dist/assets/start1.js'],
                        dest: '../src/main/webapp/dist/assets/start.js'
                    }
                ]
            }
        }
    });

    function generateAndSaveNewVersion(path) {
        var version = new Date().getTime();
        grunt.file.write(path, version);
        return version;
    }

    function generateCurrentDate() {
        var today = new Date();
        var year = today.getFullYear();
        var month = (today.getMonth() + 1) < 10 ? "0" + (today.getMonth() + 1) : (today.getMonth() + 1);
        var day = today.getDate() < 10 ? "0" + today.getDate() : today.getDate();

        var hour = today.getHours() < 10 ? "0" + today.getHours() : today.getHours();
        var minute = today.getMinutes() < 10 ? "0" + today.getMinutes() : today.getMinutes();
        var second = today.getSeconds() < 10 ? "0" + today.getSeconds() : today.getSeconds();

        return year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second;
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
    grunt.loadNpmTasks("grunt-bower-install-simple");
    grunt.loadNpmTasks('grunt-contrib-rename');

    grunt.registerTask('default', ['bower-install-simple', 'jshint', 'clean', 'copy', 'cssmin', 'htmlmin', 'uglify', 'requirejs', 'rename', 'replace']);
};