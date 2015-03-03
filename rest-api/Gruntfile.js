module.exports = function (grunt) {
    grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),
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
        concat: {
            options: {
                separator: ';'
            },
            dist: {
                src: [
                    'src/main/webapp/vendor/headjs-notify/dist/head.load.min.js',
                    'src/main/webapp/assets/js/*.js'
                ],
                dest: 'src/main/webapp/dist/<%= pkg.name %>.js'
            }
        },
        uglify: {
            my_target: {
                files: [
                    {
                        expand: true,
                        cwd: 'src/main/webapp/app',
                        src: '**/*.js',
                        dest: 'src/main/webapp/dist/app/'
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
                        cwd: 'src/main/webapp/app',
                        src: '**/*.html',
                        dest: 'src/main/webapp/dist/app/'
                    },
                    {
                        expand: true,
                        cwd: 'src/main/webapp',
                        src: '*.html',
                        dest: 'src/main/webapp/dist/'
                    }
                ]
            }
        },
        cssmin: {
            dist: {
                files: {
                    'src/main/webapp/assets/css/style.min.css': ['src/main/webapp/assets/css/*.css']
                }
            }
        }
    });
    grunt.loadNpmTasks('grunt-contrib-uglify');
    grunt.loadNpmTasks('grunt-contrib-jshint');
    grunt.loadNpmTasks('grunt-contrib-watch');
    grunt.loadNpmTasks('grunt-contrib-concat');
    grunt.loadNpmTasks('grunt-contrib-cssmin');
    grunt.loadNpmTasks('grunt-contrib-htmlmin');
    grunt.loadNpmTasks('grunt-contrib-cssmin');

    grunt.registerTask('default', ['jshint', 'uglify', 'htmlmin']);
};

